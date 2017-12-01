package org.yhonatan.practice.postal.code.distance.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yhonatan.practice.postal.code.distance.core.DistanceRequest;
import org.yhonatan.practice.postal.code.distance.core.PostalDistance;
import org.yhonatan.practice.postal.code.distance.core.PostalLocationFacade;
import org.yhonatan.practice.postal.code.distance.log.DistanceRequestLog;
import org.yhonatan.practice.postal.code.distance.service.LogService;

import static java.time.Instant.now;

@RestController
public class DistanceController {

    private final PostalLocationFacade postalLocationFacade;
    private final LogService logService;

    @Autowired
    public DistanceController(final PostalLocationFacade postalLocationFacade, final LogService logService) {
        this.postalLocationFacade = postalLocationFacade;
        this.logService = logService;
    }

    @RequestMapping("/postal-codes/{initialPostalCode}/distances/{finalPostalCode}")
    public PostalDistance getDistance(@PathVariable final String initialPostalCode, @PathVariable final String finalPostalCode) {
        final DistanceRequest distanceRequest = DistanceRequest.aDistanceRequest(initialPostalCode, finalPostalCode);

        final DistanceRequestLog distanceRequestLog = DistanceRequestLog.aDistanceRequestLog(distanceRequest, now());
        logService.saveDistanceRequestLog(distanceRequestLog);

        return postalLocationFacade.getDistance(distanceRequest);
    }

}
