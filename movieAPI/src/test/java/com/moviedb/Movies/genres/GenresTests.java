package com.moviedb.Movies.genres;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviedb.Movies.controllers.genres.GenresController;
import com.moviedb.Movies.models.Genre;
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
class GenresTests {
    final String BASE_URL = "/genres/";

    @Autowired
    private GenresController genresController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        assertThat(genresController).isNotNull();
    }

    @Test
    void getGenres() throws Exception {
        mockMvc.perform
                (get(BASE_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void addNewGenreSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(BASE_URL)
                .content(asJsonString(new Genre("Komedija")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Komedija"));
    }

    @Test
    void addNewGenreFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(BASE_URL)
                .content(asJsonString(new Genre("")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }

    @Test
    void getGenreById() throws Exception {
        final Integer dummyGenreId = 7;

        mockMvc.perform(MockMvcRequestBuilders
                .get(BASE_URL + dummyGenreId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(dummyGenreId));
    }

    @Test
    void getGenreByIdFail() throws Exception {
        final Integer dummyGenreId = 7132;

        mockMvc.perform(MockMvcRequestBuilders
                .get(BASE_URL + dummyGenreId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteGenreByIdSuccess() throws Exception {
        final Integer dummyMovieId = 7;

        mockMvc.perform(MockMvcRequestBuilders
                .delete(BASE_URL + dummyMovieId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteGenreByIdFail() throws Exception {
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
                .get(BASE_URL + dummyMovieId)
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
