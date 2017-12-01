package org.yhonatan.practice.postal.code.distance.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.yhonatan.practice.postal.code.distance.core.DistanceRequest;
import org.yhonatan.practice.postal.code.distance.jpa.entity.DistanceRequestLogEntity;
import org.yhonatan.practice.postal.code.distance.jpa.repository.DistanceRequestLogEntityRepository;
import org.yhonatan.practice.postal.code.distance.log.DistanceRequestLog;
import org.yhonatan.practice.postal.code.distance.log.DistanceRequestReport;

import java.sql.Timestamp;
import java.util.List;

import static java.sql.Timestamp.from;
import static java.time.Instant.now;
import static java.util.stream.Collectors.toList;
import static org.yhonatan.practice.postal.code.distance.log.DistanceRequestReport.aDistanceRequestLog;

@Service
public class LogService {

    private final DistanceRequestLogEntityRepository distanceRequestLogEntityRepository;

    public LogService(final DistanceRequestLogEntityRepository distanceRequestLogEntityRepository) {
        this.distanceRequestLogEntityRepository = distanceRequestLogEntityRepository;
    }

    @Async
    public void saveDistanceRequestLog(final DistanceRequestLog distanceRequestLog) {
        final DistanceRequest distanceRequest = distanceRequestLog.getDistanceRequest();
        final Timestamp requestTime = from(distanceRequestLog.getRequestInstant());
        final DistanceRequestLogEntity distanceRequestLogEntity = new DistanceRequestLogEntity(distanceRequest.getInitialPostalCode(), distanceRequest.getFinalPostalCode(), requestTime, from(now()));
        distanceRequestLogEntityRepository.save(distanceRequestLogEntity);
    }

    public List<DistanceRequestReport> getDistanceRequestLogList(final String postalCode) {
        final List<DistanceRequestLogEntity> distanceRequestLogEntityList = distanceRequestLogEntityRepository.findByInitialPostalCodeOrFinalPostalCode(postalCode, postalCode);

        return distanceRequestLogEntityList.stream()
                .map(distanceRequestLogEntity ->
                        aDistanceRequestLog(distanceRequestLogEntity.getInitialPostalCode(), distanceRequestLogEntity.getFinalPostalCode(),
                                distanceRequestLogEntity.getRequestTime().toInstant(), distanceRequestLogEntity.getCreationTime().toInstant()))
                .collect(toList());
    }
}
