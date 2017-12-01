package org.yhonatan.practice.postal.code.distance.core;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;

import static ch.obermuhlner.math.big.BigDecimalMath.cos;
import static ch.obermuhlner.math.big.BigDecimalMath.sin;
import static java.math.BigDecimal.ONE;
import static java.math.MathContext.DECIMAL32;

public class HaversineDistanceCalculator implements DistanceCalculator {

    private static final BigDecimal PI_DEGREES_EQUIVALENCE = new BigDecimal(180, DECIMAL32);
    private static final BigDecimal EARTH_RADIUS = new BigDecimal(6371, DECIMAL32);
    private static final BigDecimal DOS = new BigDecimal(2, DECIMAL32);

    public BigDecimal calculateDistance(Location initialLocation, Location finalLocation) {
        final BigDecimal a = calculateA(initialLocation, finalLocation);

        final BigDecimal c = calculateC(a);

        return EARTH_RADIUS.multiply(c, DECIMAL32);
    }

    private BigDecimal calculateA(final Location initialLocation, final Location finalLocation) {
        final BigDecimal initialLatitudeRadians = degreesToRadians(initialLocation.getLatitude());
        final BigDecimal initialLongitudeRadians = degreesToRadians(initialLocation.getLongitude());

        final BigDecimal finalLatitudeRadians = degreesToRadians(finalLocation.getLatitude());
        final BigDecimal finalLongitudeRadians = degreesToRadians(finalLocation.getLongitude());

        final BigDecimal latitudeHaversine = haversine(initialLatitudeRadians, finalLatitudeRadians);
        final BigDecimal longitudeHaversine = haversine(initialLongitudeRadians, finalLongitudeRadians);

        final BigDecimal product = cos(initialLatitudeRadians, DECIMAL32)
                .multiply(cos(finalLatitudeRadians, DECIMAL32))
                .multiply(longitudeHaversine, DECIMAL32);

        return latitudeHaversine.add(product, DECIMAL32);
    }

    private BigDecimal calculateC(final BigDecimal a) {
        final BigDecimal y = BigDecimalMath.sqrt(a, DECIMAL32);
        final BigDecimal x = BigDecimalMath.sqrt(ONE.subtract(a, DECIMAL32), DECIMAL32);

        return BigDecimalMath.atan2(y, x, DECIMAL32).multiply(DOS, DECIMAL32);
    }

    private BigDecimal degreesToRadians(final BigDecimal degrees) {
        final BigDecimal degreesFraction = degrees.divide(PI_DEGREES_EQUIVALENCE, DECIMAL32);
        return degreesFraction.multiply(BigDecimalMath.pi(DECIMAL32), DECIMAL32);
    }

    private BigDecimal haversine(final BigDecimal initDelta, final BigDecimal endDelta) {
        final BigDecimal delta = endDelta.subtract(initDelta, DECIMAL32);
        final BigDecimal sin = sin(delta.divide(DOS, DECIMAL32), DECIMAL32);
        return sin.pow(2, DECIMAL32);
    }
}
