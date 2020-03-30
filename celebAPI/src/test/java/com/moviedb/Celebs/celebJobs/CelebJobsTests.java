package com.moviedb.Celebs.celebJobs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviedb.Celebs.controllers.celebJobs.CelebJobController;
import com.moviedb.Celebs.controllers.celebs.CelebController;
import com.moviedb.Celebs.models.Celeb;
import com.moviedb.Celebs.models.CelebJobs;
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
public class CelebJobsTests {
    final String BASE_URL = "/celebjobs/";
    final String SECOND_URL = "list/";

    @Autowired
    private CelebJobController celebJobController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        assertThat(celebJobController).isNotNull();
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
    void getAllByIdTypeJob() throws Exception {
        final Integer dummyId = 1;

        mockMvc.perform(MockMvcRequestBuilders
                .get(BASE_URL + SECOND_URL + dummyId + "?type=job")
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
        final Job dummyJob = new Job("newTitle");
        final Celeb dummyCeleb = new Celeb("firstName", "lastName");

        mockMvc.perform(MockMvcRequestBuilders
                .post(BASE_URL)
                .content(asJsonString(new CelebJobs(dummyJob, dummyCeleb)))
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
        final Job dummyJob = new Job("newTitle");
        final Celeb dummyCeleb = new Celeb("firstName", "lastName");

        mockMvc.perform( MockMvcRequestBuilders
                .put(BASE_URL + dummyId)
                .content(asJsonString(new CelebJobs(dummyJob, dummyCeleb)))
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
