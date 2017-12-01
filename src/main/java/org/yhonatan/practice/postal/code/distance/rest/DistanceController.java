package org.yhonatan.practice.postal.code.distance.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yhonatan.practice.postal.code.distance.core.DistanceRequest;
import org.yhonatan.practice.postal.code.distance.core.PostalDistance;
import org.yhonatan.practice.postal.code.distance.core.PostalLocationFacade;

@RestController
public class DistanceController {

    private final PostalLocationFacade postalLocationFacade;

    @Autowired
    public DistanceController(final PostalLocationFacade postalLocationFacade) {
        this.postalLocationFacade = postalLocationFacade;
    }

    @RequestMapping("/postal-codes/{initialPostalCode}/distances/{finalPostalCode}")
    public PostalDistance getDistance(@PathVariable final String initialPostalCode, @PathVariable final String finalPostalCode) {
        final DistanceRequest distanceRequest = DistanceRequest.aDistanceRequest(initialPostalCode, finalPostalCode);
        return postalLocationFacade.getDistance(distanceRequest);
    }

}
