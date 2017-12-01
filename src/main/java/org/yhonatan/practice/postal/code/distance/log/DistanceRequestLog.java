package org.yhonatan.practice.postal.code.distance.log;

import org.yhonatan.practice.postal.code.distance.core.DistanceRequest;

import java.time.Instant;

public class DistanceRequestLog {

    private final DistanceRequest distanceRequest;
    private final Instant requestInstant;

    private DistanceRequestLog(DistanceRequest distanceRequest, Instant requestInstant) {
        this.distanceRequest = distanceRequest;
        this.requestInstant = requestInstant;
    }

    public DistanceRequest getDistanceRequest() {
        return distanceRequest;
    }

    public Instant getRequestInstant() {
        return requestInstant;
    }

    public static DistanceRequestLog aDistanceRequestLog(final DistanceRequest distanceRequest, final Instant requestInstant) {
        return new DistanceRequestLog(distanceRequest, requestInstant);
    }
}
