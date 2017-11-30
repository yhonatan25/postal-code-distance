package org.yhonatan.practice.postal.code.distance.jpa;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoRule;
import org.yhonatan.practice.postal.code.distance.core.Location;
import org.yhonatan.practice.postal.code.distance.core.PostalLocation;
import org.yhonatan.practice.postal.code.distance.jpa.entity.PostalLocationEntity;
import org.yhonatan.practice.postal.code.distance.jpa.exception.PostalCodeNotFoundException;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.junit.MockitoJUnit.rule;

public class JpaPostalLocationServiceTest {

    private static final long ID = 1L;
    private static final String POSTAL_CODE = "AB10 1XG";
    private static final BigDecimal LATITUDE = valueOf(57.14416516);
    private static final BigDecimal LONGITUDE = valueOf(-2.114847768);
    private static final PostalLocationEntity POSTAL_LOCATION_ENTITY = new PostalLocationEntity(ID, POSTAL_CODE, LATITUDE, LONGITUDE);

    @Rule
    public MockitoRule mockitoRule = rule();

    @Mock
    private PostalLocationEntityRepository postalLocationEntityRepository;

    @InjectMocks
    private JpaPostalLocationService jpaPostalLocationService;

    @Test
    public void testGetPostalLocation() {
        when(postalLocationEntityRepository.getByPostalCode(POSTAL_CODE)).thenReturn(POSTAL_LOCATION_ENTITY);

        final PostalLocation postalLocation = jpaPostalLocationService.getPostalLocation(POSTAL_CODE);

        verify(postalLocationEntityRepository).getByPostalCode(POSTAL_CODE);

        assertThat(postalLocation.getPostalCode(), is(POSTAL_CODE));
        final Location location = postalLocation.getLocation();
        assertThat(location.getLatitude(), is(LATITUDE));
        assertThat(location.getLongitude(), is(LONGITUDE));
    }

    @Test(expected = PostalCodeNotFoundException.class)
    public void testGetPostalLocationWhenPostalCodeNotFound() {
        when(postalLocationEntityRepository.getByPostalCode(POSTAL_CODE)).thenReturn(null);

        final PostalLocation postalLocation = jpaPostalLocationService.getPostalLocation(POSTAL_CODE);

    }

}
