package org.yhonatan.practice.postal.code.distance.core;

import org.springframework.util.Assert;

public class DistanceRequest {

    private final String initialPostalCode;

    private final String finalPostalCode;

    private DistanceRequest(final String initialPostalCode, final String finalPostalCode) {
        this.initialPostalCode = initialPostalCode;
        this.finalPostalCode = finalPostalCode;
    }

    public String getInitialPostalCode() {
        return initialPostalCode;
    }

    public String getFinalPostalCode() {
        return finalPostalCode;
    }

    public static DistanceRequest aDistanceRequest(final String initialPostalCode, final String finalPostalCode) {
        Assert.hasText(initialPostalCode, "Initial postal code must have text.");
        Assert.hasText(finalPostalCode, "Final postal code must have text.");
        return new DistanceRequest(initialPostalCode, finalPostalCode);
    }
}
