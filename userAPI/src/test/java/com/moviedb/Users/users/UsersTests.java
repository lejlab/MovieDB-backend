package com.moviedb.Users.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviedb.Users.controllers.users.UsersController;
import com.moviedb.Users.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class UsersTests {
    final String BASE_URL = "/users/";

    @Autowired
    private UsersController usersController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        assertThat(usersController).isNotNull();
    }

    @Test
    void getUsers() throws Exception {
        mockMvc.perform
                (get(BASE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void addNewUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(BASE_URL)
                .content(asJsonString(new User("test_username4", "test_password4", "test_avatarUrl4")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("test_username4"));
    }

    @Test
    void getUserById() throws Exception {
        final Integer dummyUserId = 35;

        mockMvc.perform(MockMvcRequestBuilders
                .get(BASE_URL + dummyUserId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(dummyUserId));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
