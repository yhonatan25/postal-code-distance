package org.yhonatan.practice.postal.code.distance.core;

import org.junit.Test;

import static org.yhonatan.practice.postal.code.distance.core.DistanceRequest.aDistanceRequest;

public class DistanceRequestTest {

    private static final String POSTAL_CODE = "AB10 1XG";

    @Test(expected = IllegalArgumentException.class)
    public void testCreateADistanceRequestWhenReceivingNullInitialPostalCode() {
        aDistanceRequest(null, POSTAL_CODE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateADistanceRequestWhenReceivingEmptyInitialPostalCode() {
        aDistanceRequest("", POSTAL_CODE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateADistanceRequestWhenReceivingNullFinalPostalCode() {
        aDistanceRequest(POSTAL_CODE, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateADistanceRequestWhenReceivingEmptyFinalPostalCode() {
        aDistanceRequest(POSTAL_CODE, "");
    }
}