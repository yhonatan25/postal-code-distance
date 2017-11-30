package org.yhonatan.practice.postal.code.distance.core;

import java.math.BigDecimal;

class Location {

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
        return new Location(latitude, longitude);
    }

}
