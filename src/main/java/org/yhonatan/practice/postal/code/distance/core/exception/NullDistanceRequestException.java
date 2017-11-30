package org.yhonatan.practice.postal.code.distance.core.exception;

public class NullDistanceRequestException extends IllegalArgumentException {

    public NullDistanceRequestException() {
        super("Distance request must not be null.");
    }

}
