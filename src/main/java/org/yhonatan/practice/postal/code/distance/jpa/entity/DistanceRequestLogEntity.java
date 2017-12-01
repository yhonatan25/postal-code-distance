package org.yhonatan.practice.postal.code.distance.jpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "distance_requests")
public class DistanceRequestLogEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "initial_postal_code", nullable = false)
    private String initialPostalCode;

    @Column(name = "final_postal_code", nullable = false)
    private String finalPostalCode;

    @Column(name = "request_time", nullable = false)
    private Timestamp requestTime;

    @Column(name = "creation_time", nullable = false)
    private Timestamp creationTime;

    public DistanceRequestLogEntity() {

    }

    public DistanceRequestLogEntity(final String initialPostalCode, final String finalPostalCode, final Timestamp requestTime, final Timestamp creationTime) {
        this.initialPostalCode = initialPostalCode;
        this.finalPostalCode = finalPostalCode;
        this.requestTime = requestTime;
        this.creationTime = creationTime;
    }

    public DistanceRequestLogEntity(final Long id, final String initialPostalCode, final String finalPostalCode,
                                    final Timestamp requestTime, final Timestamp creationTime) {
        this.id = id;
        this.initialPostalCode = initialPostalCode;
        this.finalPostalCode = finalPostalCode;
        this.requestTime = requestTime;
        this.creationTime = creationTime;
    }

    public Long getId() {
        return id;
    }

    public String getInitialPostalCode() {
        return initialPostalCode;
    }

    public String getFinalPostalCode() {
        return finalPostalCode;
    }

    public Timestamp getRequestTime() {
        return requestTime;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }
}
