package com.moviedb.Celebs.movieCelebs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviedb.Celebs.controllers.celebJobs.CelebJobController;
import com.moviedb.Celebs.controllers.movieCelebs.MovieCelebController;
import com.moviedb.Celebs.models.Celeb;
import com.moviedb.Celebs.models.CelebJobs;
import com.moviedb.Celebs.models.Job;
import com.moviedb.Celebs.models.MovieCeleb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieCelebsTests {
    final String BASE_URL = "/moviecelebs/";
    final String SECOND_URL = "list/";

    @Autowired
    private MovieCelebController movieCelebController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        assertThat(movieCelebController).isNotNull();
    }

    /**********************GET***********************/

    @Test
    void getAll() throws Exception {
        mockMvc.perform
                (get(BASE_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getOneById() throws Exception {
        final Integer dummyId = 1;

        mockMvc.perform(MockMvcRequestBuilders
                .get(BASE_URL + dummyId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(dummyId));
    }

    @Test
    void getOneByIdNF() throws Exception {
        final Integer dummyId = 99;

        mockMvc.perform(MockMvcRequestBuilders
                .get(BASE_URL + dummyId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllByIdTypeCeleb() throws Exception {
        final Integer dummyId = 1;

        mockMvc.perform(MockMvcRequestBuilders
                .get(BASE_URL + SECOND_URL + dummyId + "?type=celeb")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getAllByIdTypeMovie() throws Exception {
        final Integer dummyId = 1;

        mockMvc.perform(MockMvcRequestBuilders
                .get(BASE_URL + SECOND_URL + dummyId + "?type=movie")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getAllBySomethingTypeNF() throws Exception {
        final Integer dummyId = 1;
        final String dummyType = "dummyType";

        mockMvc.perform(MockMvcRequestBuilders
                .get(BASE_URL + SECOND_URL + dummyId + "?type=" + dummyType)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    /**********************POST***********************/

    @Test
    void addOne() throws Exception {
        final Integer dummyMovieId = 1;
        final Celeb dummyCeleb = new Celeb("firstName", "lastName");

        mockMvc.perform(MockMvcRequestBuilders
                .post(BASE_URL)
                .content(asJsonString(new MovieCeleb(dummyCeleb, dummyMovieId)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    /**********************PUT***********************/
    @Test
    public void editOne() throws Exception
    {
        final Integer dummyId = 1;
        final Integer dummyMovieId = 1;
        final Celeb dummyCeleb = new Celeb("firstName", "lastName");

        mockMvc.perform( MockMvcRequestBuilders
                .put(BASE_URL + dummyId)
                .content(asJsonString(new MovieCeleb(dummyCeleb, dummyMovieId)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /********************DELETE**********************/

    @Test
    public void removeOne() throws Exception
    {
        final Integer dummyId = 1;

        mockMvc.perform( MockMvcRequestBuilders.delete(BASE_URL + dummyId))
                .andExpect(status().isAccepted());
    }
    
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}