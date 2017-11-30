package org.yhonatan.practice.postal.code.distance.core;

import org.junit.Test;

import static java.math.BigDecimal.ONE;
import static org.yhonatan.practice.postal.code.distance.core.Location.aLocation;

public class LocationTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateALocationWhenLatitudeIsNull() {
        aLocation(null, ONE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateALocationWhenLongitudeIsNull() {
        aLocation(ONE, null);
    }

}