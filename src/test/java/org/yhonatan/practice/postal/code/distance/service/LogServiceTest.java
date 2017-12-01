package org.yhonatan.practice.postal.code.distance.service;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.yhonatan.practice.postal.code.distance.core.DistanceRequest;
import org.yhonatan.practice.postal.code.distance.jpa.entity.DistanceRequestLogEntity;
import org.yhonatan.practice.postal.code.distance.jpa.repository.DistanceRequestLogEntityRepository;
import org.yhonatan.practice.postal.code.distance.log.DistanceRequestLog;
import org.yhonatan.practice.postal.code.distance.log.DistanceRequestReport;

import java.time.Instant;
import java.util.List;

import static java.sql.Timestamp.from;
import static java.time.Instant.now;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.yhonatan.practice.postal.code.distance.core.DistanceRequest.aDistanceRequest;

public class LogServiceTest {

    private static final String INITIAL_POSTAL_CODE = "AB10 1XG";
    private static final String FINAL_POSTAL_CODE = "AB15 6NA";
    private static final String POSTAL_CODE = "AB10 1XG";
    private static final Instant REQUEST_INSTANT = now();
    private static final Instant CREATION_INSTANT = now();

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private DistanceRequestLogEntityRepository distanceRequestLogEntityRepository;

    @InjectMocks
    private LogService logService;

    @Test
    public void testSaveDistanceRequestLog() {
        final DistanceRequest distanceRequest = aDistanceRequest(INITIAL_POSTAL_CODE, FINAL_POSTAL_CODE);
        final DistanceRequestLog distanceRequestLog = DistanceRequestLog.aDistanceRequestLog(distanceRequest, now());

        logService.saveDistanceRequestLog(distanceRequestLog);

        verify(distanceRequestLogEntityRepository).save(any(DistanceRequestLogEntity.class));
    }

    @Test
    public void testGetDistanceRequestLog() {
        when(distanceRequestLogEntityRepository.findByInitialPostalCodeOrFinalPostalCode(POSTAL_CODE, POSTAL_CODE)).thenReturn(getDistanceRequestLogEntityList());

        final List<DistanceRequestReport> distanceRequestLogList = logService.getDistanceRequestLogList(POSTAL_CODE);

        verify(distanceRequestLogEntityRepository).findByInitialPostalCodeOrFinalPostalCode(POSTAL_CODE, POSTAL_CODE);
        final DistanceRequestReport distanceRequestReport = distanceRequestLogList.get(0);
        assertThat(distanceRequestReport.getInitialPostalCode(), is(INITIAL_POSTAL_CODE));
        assertThat(distanceRequestReport.getFinalPostalCode(), is(FINAL_POSTAL_CODE));
        assertThat(distanceRequestReport.getRequestInstant(), is(REQUEST_INSTANT));
        assertThat(distanceRequestReport.getCreationInstant(), is(CREATION_INSTANT));

    }

    private List<DistanceRequestLogEntity> getDistanceRequestLogEntityList() {
        final DistanceRequestLogEntity distanceRequestLogEntity = new DistanceRequestLogEntity(1L, INITIAL_POSTAL_CODE, FINAL_POSTAL_CODE, from(REQUEST_INSTANT), from(CREATION_INSTANT));
        return asList(distanceRequestLogEntity);
    }

}