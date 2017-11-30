package org.yhonatan.practice.postal.code.distance.core;

import org.springframework.util.Assert;

import java.math.BigDecimal;

public class Location {

    private final BigDecimal latitude;

    private final BigDecimal longitude;

    private Location(final BigDecimal latitude, final BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public static Location aLocation(final BigDecimal latitude, final BigDecimal longitude) {
        Assert.isTrue(latitude != null, "Latitude must not be null.");
        Assert.isTrue(longitude != null, "Longitude must not be null.");
        return new Location(latitude, longitude);
    }

}
