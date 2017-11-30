package org.yhonatan.practice.postal.code.distance.core;

import org.yhonatan.practice.postal.code.distance.core.exception.NullDistanceRequestException;

import java.math.BigDecimal;

import static org.yhonatan.practice.postal.code.distance.core.PostalDistance.PostalDistanceBuilder.aPostalDistance;

public class PostalLocationFacade {

    private final PostalLocationService postalLocationService;

    private final DistanceCalculator distanceCalculator;

    public PostalLocationFacade(final PostalLocationService postalLocationService, final DistanceCalculator distanceCalculator) {
        this.postalLocationService = postalLocationService;
        this.distanceCalculator = distanceCalculator;
    }

    public PostalDistance getDistance(final DistanceRequest distanceRequest) {
        assertDistanceRequestIsNotNull(distanceRequest);

        final PostalLocation initialPostalLocation = postalLocationService.getPostalLocation(distanceRequest.getInitialPostalCode());
        final PostalLocation finalPostalLocation = postalLocationService.getPostalLocation(distanceRequest.getFinalPostalCode());

        final Location initialLocation = initialPostalLocation.getLocation();
        final Location finalLocation = finalPostalLocation.getLocation();
        final BigDecimal distance = distanceCalculator.calculateDistance(initialLocation, finalLocation);

        return aPostalDistance(initialPostalLocation, finalPostalLocation, distance).build();
    }

    private void assertDistanceRequestIsNotNull(final DistanceRequest distanceRequest) {
        if (distanceRequest == null) {
            throw new NullDistanceRequestException();
        }
    }
}
