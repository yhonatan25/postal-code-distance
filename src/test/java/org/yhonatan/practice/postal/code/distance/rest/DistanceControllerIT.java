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
public class DistanceControllerIT {
    private static final String INITIAL_POSTAL_CODE = "AB10 1XG";
    private static final String FINAL_POSTAL_CODE = "AB15 6NA";
    private static final BigDecimal DISTANCE = valueOf(4.3394);
    private static final String UNIT = "km";

    private static final String NOT_FOUND_POSTAL_CODE = "WV7 3LY";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetDistance() throws Exception {
        mockMvc.perform(get("/postal-codes/{initialPostalCode}/distances/{finalPostalCode}", INITIAL_POSTAL_CODE, FINAL_POSTAL_CODE)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.initialPostalLocation.postalCode").value(INITIAL_POSTAL_CODE))
                .andExpect(jsonPath("$.initialPostalLocation.location.latitude").exists())
                .andExpect(jsonPath("$.initialPostalLocation.location.longitude").exists())
                .andExpect(jsonPath("$.finalPostalLocation.postalCode").value(FINAL_POSTAL_CODE))
                .andExpect(jsonPath("$.finalPostalLocation.location.latitude").exists())
                .andExpect(jsonPath("$.finalPostalLocation.location.longitude").exists())
                .andExpect(jsonPath("$.distance").value(DISTANCE))
                .andExpect(jsonPath("$.unit").value(UNIT));
    }

    @Test
    public void testGetDistanceWhenInitialPostalCodeNotFound() throws Exception {
        mockMvc.perform(get("/postal-codes/{initialPostalCode}/distances/{finalPostalCode}", NOT_FOUND_POSTAL_CODE, FINAL_POSTAL_CODE)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetDistanceWhenFinalPostalCodeNotFound() throws Exception {
        mockMvc.perform(get("/postal-codes/{initialPostalCode}/distances/{finalPostalCode}", INITIAL_POSTAL_CODE, NOT_FOUND_POSTAL_CODE)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNotFound());
    }

}
