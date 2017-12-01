package org.yhonatan.practice.postal.code.distance.rest;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.yhonatan.practice.postal.code.distance.core.DistanceRequest;
import org.yhonatan.practice.postal.code.distance.core.PostalLocationFacade;
import org.yhonatan.practice.postal.code.distance.log.DistanceRequestLog;
import org.yhonatan.practice.postal.code.distance.service.LogService;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class DistanceControllerTest {

    private static final String INITIAL_POSTAL_CODE = "AB10 1XG";
    private static final String FINAL_POSTAL_CODE = "AB15 6NA";

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private PostalLocationFacade postalLocationFacade;

    @Mock
    private LogService logService;

    @InjectMocks
    private DistanceController distanceController;

    @Test
    public void getDistance() {

        distanceController.getDistance(INITIAL_POSTAL_CODE, FINAL_POSTAL_CODE);

        verify(postalLocationFacade).getDistance(any(DistanceRequest.class));
        verify(logService).saveDistanceRequestLog(any(DistanceRequestLog.class));
    }

}