package org.yhonatan.practice.postal.code.distance.core;

import org.springframework.util.Assert;

class PostalLocation {

    private final String postalCode;

    private final Location location;

    public PostalLocation(final String postalCode, final Location location) {
        this.postalCode = postalCode;
        this.location = location;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Location getLocation() {
        return location;
    }

    public static PostalLocation aPostalLocation(final String postalCode, final Location location) {
        Assert.hasText(postalCode, "Postal code must to have text.");
        Assert.isTrue(location != null, "Location must not be null.");
        return new PostalLocation(postalCode, location);
    }
}
