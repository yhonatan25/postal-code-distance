package org.yhonatan.practice.postal.code.distance.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RequestLogControllerIT {
    private static final String INITIAL_POSTAL_CODE = "AB10 1XG";
    private static final String FINAL_POSTAL_CODE = "AB15 6NA";
    private static final BigDecimal DISTANCE = valueOf(4.3394);
    private static final String UNIT = "km";

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
                .andExpect(jsonPath("$.initialPostalCode").exists());
    }
}
