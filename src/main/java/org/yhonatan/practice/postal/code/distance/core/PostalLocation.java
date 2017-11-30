package org.yhonatan.practice.postal.code.distance.core;

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
        return new PostalLocation(postalCode, location);
    }
}
