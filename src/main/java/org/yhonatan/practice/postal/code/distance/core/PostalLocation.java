package org.yhonatan.practice.postal.code.distance.core;

import java.math.BigDecimal;

public class PostalLocation {

    private final String postalCode;

    private final BigDecimal latitude;

    private final BigDecimal longitude;

    public PostalLocation(final String postalCode, final BigDecimal latitude, final BigDecimal longitude) {
        this.postalCode = postalCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public static PostalLocation aPostalUbication(final String postalCode, final BigDecimal latitude, final BigDecimal longitude) {
        return new PostalLocation(postalCode, latitude, longitude);
    }
}
