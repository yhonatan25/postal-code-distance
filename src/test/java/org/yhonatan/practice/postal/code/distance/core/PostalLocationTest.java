package org.yhonatan.practice.postal.code.distance.core;

import org.junit.Test;

import static java.math.BigDecimal.ONE;
import static org.yhonatan.practice.postal.code.distance.core.Location.aLocation;
import static org.yhonatan.practice.postal.code.distance.core.PostalLocation.aPostalLocation;

public class PostalLocationTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAPostalLocationWhenPostalCodeIsNull() {
        aPostalLocation(null, aLocation(ONE, ONE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAPostalLocationWhenPostalCodeIsEmpty() {
        aPostalLocation("", aLocation(ONE, ONE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAPostalLocationWhenLocationIsNull() {
        aPostalLocation("AB10 1XG", null);
    }

}