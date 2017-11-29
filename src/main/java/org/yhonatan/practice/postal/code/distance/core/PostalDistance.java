package org.yhonatan.practice.postal.code.distance.core;

import java.math.BigDecimal;

public class PostalDistance {

    private final PostalLocation initialPostalLocation;

    private final PostalLocation finalPostalLocation;

    private final BigDecimal distance;

    private final String unit;


    private PostalDistance(final PostalDistanceBuilder postalDistanceBuilder) {
        this.initialPostalLocation = postalDistanceBuilder.initialPostalLocation;
        this.finalPostalLocation = postalDistanceBuilder.finalPostalLocation;
        this.distance = postalDistanceBuilder.distance;
        this.unit = postalDistanceBuilder.unit;
    }

    public PostalLocation getInitialPostalLocation() {
        return initialPostalLocation;
    }

    public PostalLocation getFinalPostalLocation() {
        return finalPostalLocation;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public String getUnit() {
        return unit;
    }

    public static class PostalDistanceBuilder {

        private final PostalLocation initialPostalLocation;

        private final PostalLocation finalPostalLocation;

        private final BigDecimal distance;

        private String unit = "km";

        private PostalDistanceBuilder(final PostalLocation initialPostalLocation, final PostalLocation finalPostalLocation, final BigDecimal distance) {
            this.initialPostalLocation = initialPostalLocation;
            this.finalPostalLocation = finalPostalLocation;
            this.distance = distance;
        }

        public static PostalDistanceBuilder aPostalDistance(final PostalLocation initialPostalLocation, final PostalLocation finalPostalLocation, final BigDecimal distance) {
            return new PostalDistanceBuilder(initialPostalLocation, finalPostalLocation, distance);
        }

        public PostalDistanceBuilder unit(final String unit) {
            this.unit = unit;
            return this;
        }

        public PostalDistance build() {
            return new PostalDistance(this);
        }

    }
}