package org.yhonatan.practice.postal.code.distance.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = BEFORE_CLASS)
public class RequestLogControllerIT {
    private static final String INITIAL_POSTAL_CODE = "AB10 1XG";
    private static final String FINAL_POSTAL_CODE = "AB15 6NA";
    private static final String POSTAL_CODE = "AB10 1XG";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetDistance() throws Exception {
        mockMvc.perform(get("/postal-codes/{initialPostalCode}/distances/{finalPostalCode}", INITIAL_POSTAL_CODE, FINAL_POSTAL_CODE)
                .accept(MediaType.APPLICATION_JSON_UTF8));

        mockMvc.perform(get("/requests?postal-code={postalCode}", POSTAL_CODE)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].initialPostalCode").value(INITIAL_POSTAL_CODE))
                .andExpect(jsonPath("$.[0].finalPostalCode").value(FINAL_POSTAL_CODE))
                .andExpect(jsonPath("$.[0].creationInstant").exists())
                .andExpect(jsonPath("$.[0].requestInstant").exists());
    }
}
