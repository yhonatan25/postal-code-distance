package org.yhonatan.practice.postal.code.distance.core;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.yhonatan.practice.postal.code.distance.core.exception.NullDistanceRequestException;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.valueOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.yhonatan.practice.postal.code.distance.core.DistanceRequest.aDistanceRequest;
import static org.yhonatan.practice.postal.code.distance.core.Location.aLocation;
import static org.yhonatan.practice.postal.code.distance.core.PostalLocation.aPostalLocation;

public class PostalLocationFacadeTest {

    private static final String INITIAL_POSTAL_CODE = "AB10 1XG";
    private static final String FINAL_POSTAL_CODE = "AB15 6NA";
    private static final Location INITIAL_LOCATION = aLocation(valueOf(57.14416516), valueOf(-2.114847768));
    private static final Location FINAL_LOCATION = aLocation(valueOf(57.151797), valueOf(-2.185398));
    private static final PostalLocation INITIAL_POSTAL_LOCATION = aPostalLocation(INITIAL_POSTAL_CODE, INITIAL_LOCATION);
    private static final PostalLocation FINAL_POSTAL_LOCATION = aPostalLocation(FINAL_POSTAL_CODE, FINAL_LOCATION);
    public static final String EXPECTED_UNIT = "km";

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private PostalLocationService postalLocationService;

    @Mock
    private DistanceCalculator distanceCalculator;

    @InjectMocks
    private PostalLocationFacade postalLocationFacade;

    @Test
    public void testGetDistance() {
        when(postalLocationService.getPostalLocation(INITIAL_POSTAL_CODE)).thenReturn(INITIAL_POSTAL_LOCATION);
        when(postalLocationService.getPostalLocation(FINAL_POSTAL_CODE)).thenReturn(FINAL_POSTAL_LOCATION);
        when(distanceCalculator.calculateDistance(INITIAL_LOCATION, FINAL_LOCATION)).thenReturn(ONE);

        final DistanceRequest distanceRequest = aDistanceRequest(INITIAL_POSTAL_CODE, FINAL_POSTAL_CODE);
        final PostalDistance postalDistance = postalLocationFacade.getDistance(distanceRequest);

        verify(postalLocationService).getPostalLocation(INITIAL_POSTAL_CODE);
        verify(postalLocationService).getPostalLocation(FINAL_POSTAL_CODE);
        verify(distanceCalculator).calculateDistance(INITIAL_LOCATION, FINAL_LOCATION);

        assertThat(postalDistance.getInitialPostalLocation(), is(INITIAL_POSTAL_LOCATION));
        assertThat(postalDistance.getFinalPostalLocation(), is(FINAL_POSTAL_LOCATION));
        assertThat(postalDistance.getDistance(), is(ONE));
        assertThat(postalDistance.getUnit(), is(EXPECTED_UNIT));
    }

    @Test(expected = NullDistanceRequestException.class)
    public void testGetDistanceWhenDistanceRequestIsNull() {
        final DistanceRequest distanceRequest = null;
        final PostalDistance postalDistance = postalLocationFacade.getDistance(distanceRequest);
    }
}
