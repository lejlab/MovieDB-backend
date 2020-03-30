package com.moviedb.Movies.genreMovies;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviedb.Movies.controllers.genreMovies.GenreMoviesController;
import com.moviedb.Movies.controllers.movies.exceptions.MovieNotFoundException;
import com.moviedb.Movies.models.Genre;
import com.moviedb.Movies.models.GenreMovie;
import com.moviedb.Movies.models.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GenreMoviesTests {
    final String BASE_URL = "/genreMovies/";

    @Autowired
    private GenreMoviesController genreMoviesController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        assertThat(genreMoviesController).isNotNull();
    }

    @Test
    void getGenreMovies() throws Exception {
        mockMvc.perform
                (get(BASE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getGenres() throws Exception {
        mockMvc.perform
                (get(BASE_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void addNewGenreMovieSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(BASE_URL)
                .content(asJsonString(new GenreMovie(new Genre("sasa"),new Movie())))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Komedija"));
    }

    @Test
    void addNewGenreMovieFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(BASE_URL)
                .content(asJsonString(new GenreMovie(new Genre(""),new Movie())))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }

    @Test
    void getGenreMovieById() throws Exception {
        final Integer dummyGenreId = 7;

        mockMvc.perform(MockMvcRequestBuilders
                .get(BASE_URL + dummyGenreId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getGenreMovieByIdFail() throws Exception {
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
    void editGenreMovieByIdSuccess() throws Exception {
        final Integer dummyMovieId = 9;

        mockMvc.perform(MockMvcRequestBuilders
                .put(BASE_URL + dummyMovieId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void editGenreMovieByIdFail() throws Exception {
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
