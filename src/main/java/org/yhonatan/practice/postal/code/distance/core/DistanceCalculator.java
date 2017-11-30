package org.yhonatan.practice.postal.code.distance.core;

import java.math.BigDecimal;

public interface DistanceCalculator {

    BigDecimal calculateDistance(final Location initialLocation, final Location finalLocation);

}
