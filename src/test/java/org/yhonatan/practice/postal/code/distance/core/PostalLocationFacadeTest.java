package org.yhonatan.practice.postal.code.distance.core;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;
import static org.yhonatan.practice.postal.code.distance.core.DistanceRequest.aDistanceRequest;

public class PostalLocationFacadeTest {

    public static final String INITIAL_POSTAL_CODE = "AB10 1XG";
    public static final String FINAL_POSTAL_CODE = "AB15 6NA";

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private PostalLocationService postalLocationService;

    @Mock
    private DistanceCalculator distanceCalculator;

    @InjectMocks
    private PostalLocationFacade postalLocationFacade;

    @Test
    public void testGetDistance() throws Exception {

        final DistanceRequest distanceRequest = aDistanceRequest(INITIAL_POSTAL_CODE, FINAL_POSTAL_CODE);

        final PostalDistance postalDistance = postalLocationFacade.getDistance(distanceRequest);

        verify(postalLocationService).getPostalLocation(INITIAL_POSTAL_CODE);
        verify(postalLocationService).getPostalLocation(FINAL_POSTAL_CODE);


    }
}
