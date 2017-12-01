package org.yhonatan.practice.postal.code.distance.log;

import java.time.Instant;

public class DistanceRequestReport {

    private final String initialPostalCode;
    private final String finalPostalCode;
    private final Instant requestInstant;
    private final Instant creationInstant;

    private DistanceRequestReport(final String initialPostalCode, final String finalPostalCode, final Instant requestInstant, final Instant creationInstant) {
        this.initialPostalCode = initialPostalCode;
        this.finalPostalCode = finalPostalCode;
        this.requestInstant = requestInstant;
        this.creationInstant = creationInstant;
    }

    public String getInitialPostalCode() {
        return initialPostalCode;
    }

    public String getFinalPostalCode() {
        return finalPostalCode;
    }

    public Instant getRequestInstant() {
        return requestInstant;
    }

    public Instant getCreationInstant() {
        return creationInstant;
    }

    public static DistanceRequestReport aDistanceRequestLog(final String initialPostalCode, final String finalPostalcode, final Instant requestInstant, final Instant creationInstant) {
        return new DistanceRequestReport(initialPostalCode, finalPostalcode, requestInstant, creationInstant);
    }

}
