package org.yhonatan.practice.postal.code.distance.jpa.exception;

public class PostalCodeNotFoundException extends RuntimeException {

    public PostalCodeNotFoundException(final String postalCode) {
        super("Postal code: " + postalCode + "not found.");
    }

}
