package org.yhonatan.practice.postal.code.distance.rest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.yhonatan.practice.postal.code.distance.jpa.exception.PostalCodeNotFoundException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(PostalCodeNotFoundException.class)
    public void postalCodeNotFound() {

    }

}
