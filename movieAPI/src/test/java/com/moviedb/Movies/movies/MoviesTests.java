package com.moviedb.Movies.movies;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviedb.Movies.controllers.movies.MoviesController;
import com.moviedb.Movies.models.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class MoviesTests {
    final String BASE_URL = "/movies/";

    @Autowired
    private MoviesController moviesController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        assertThat(moviesController).isNotNull();
    }

    @Test
    void getMovies() throws Exception {
        mockMvc.perform
                (get(BASE_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void addNewMovie() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(BASE_URL)
                .content(asJsonString(new Movie("Mad max 2", new Date(), 4567)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Mad max 2"));
    }

    @Test
    void getMovieByIdSuccess() throws Exception {
        final Integer dummyMovieId = 7;

        mockMvc.perform(MockMvcRequestBuilders
                .get(BASE_URL + dummyMovieId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(dummyMovieId));
    }

    @Test
    void getMovieByIdFail() throws Exception {
        final Integer dummyMovieId = 3579;

        mockMvc.perform(MockMvcRequestBuilders
                .get(BASE_URL + dummyMovieId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteMovieByIdSuccess() throws Exception {
        final Integer dummyMovieId = 7;

        mockMvc.perform(MockMvcRequestBuilders
                .delete(BASE_URL + dummyMovieId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteMovieByIdFail() throws Exception {
        final Integer dummyMovieId = 731;

        mockMvc.perform(MockMvcRequestBuilders
                .delete(BASE_URL + dummyMovieId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }

    @Test
    void editMovieByIdSuccess() throws Exception {
        final Integer dummyMovieId = 9;

        mockMvc.perform(MockMvcRequestBuilders
                .put(BASE_URL + dummyMovieId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void editMovieByIdFail() throws Exception {
        final Integer dummyMovieId = 7331;

        mockMvc.perform(MockMvcRequestBuilders
                .put(BASE_URL + dummyMovieId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
