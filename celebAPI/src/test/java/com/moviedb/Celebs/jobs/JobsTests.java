package com.moviedb.Celebs.jobs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviedb.Celebs.controllers.jobs.JobController;
import com.moviedb.Celebs.models.Job;
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
public class JobsTests {
    final String BASE_URL = "/jobs/";

    @Autowired
    private JobController jobController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        assertThat(jobController).isNotNull();
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


    /**********************POST***********************/

    @Test
    void addOne() throws Exception {
        final String dummyTitle = "newTitle";

        mockMvc.perform(MockMvcRequestBuilders
                .post(BASE_URL)
                .content(asJsonString(new Job(dummyTitle)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(dummyTitle));
    }


    /**********************PUT***********************/
    @Test
    public void editOne() throws Exception
    {
        final Integer dummyId = 1;
        final String dummyTitle = "newTitle";

        mockMvc.perform( MockMvcRequestBuilders
                .put(BASE_URL + dummyId)
                .content(asJsonString(new Job(dummyTitle)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(dummyTitle));
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
