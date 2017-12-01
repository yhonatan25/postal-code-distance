package org.yhonatan.practice.postal.code.distance.core;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL32;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.yhonatan.practice.postal.code.distance.core.Location.aLocation;

public class HaversineDistanceCalculatorTest {

    private static final Location INITIAL_LOCATION = aLocation(new BigDecimal(57.14416516, DECIMAL32), new BigDecimal(-2.114847768, DECIMAL32));
    private static final Location FINAL_LOCATION = aLocation(new BigDecimal(53.3563748, DECIMAL32), new BigDecimal(-2.1655145, DECIMAL32));
    private static final BigDecimal EXPECTED_DISTANCE = new BigDecimal(421.19572940, DECIMAL32);

    private DistanceCalculator haversineDistanceCalculator;

    @Before
    public void setup() {
        haversineDistanceCalculator = new HaversineDistanceCalculator();
    }

    @Test
    public void testCalculateDistance() {
        final BigDecimal distance = haversineDistanceCalculator.calculateDistance(INITIAL_LOCATION, FINAL_LOCATION);
        assertThat(EXPECTED_DISTANCE, CoreMatchers.equalTo(distance));
    }

}
