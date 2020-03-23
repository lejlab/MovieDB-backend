package com.moviedb.Users.subscriptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviedb.Users.controllers.subscriptions.SubscriptionsController;
import com.moviedb.Users.models.Subscribe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SubscriptionsTests {
    final String BASE_URL = "/subscriptions/";

    @Autowired
    private SubscriptionsController subscriptionsController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        assertThat(subscriptionsController).isNotNull();
    }

    @Test
    void getSubscriptions() throws Exception {
        mockMvc.perform
                (get(BASE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void addNewSubscriptionNoUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(BASE_URL)
                .content(asJsonString(new Subscribe(null, null)))
                .contentType(MediaType.APPLICATION_JSON)
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
