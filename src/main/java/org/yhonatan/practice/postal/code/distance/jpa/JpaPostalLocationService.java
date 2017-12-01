package org.yhonatan.practice.postal.code.distance.jpa;

import org.yhonatan.practice.postal.code.distance.core.Location;
import org.yhonatan.practice.postal.code.distance.core.PostalLocation;
import org.yhonatan.practice.postal.code.distance.core.PostalLocationService;
import org.yhonatan.practice.postal.code.distance.jpa.entity.PostalLocationEntity;
import org.yhonatan.practice.postal.code.distance.jpa.exception.PostalCodeNotFoundException;

import static org.yhonatan.practice.postal.code.distance.core.Location.aLocation;
import static org.yhonatan.practice.postal.code.distance.core.PostalLocation.aPostalLocation;

public class JpaPostalLocationService implements PostalLocationService {

    private final PostalLocationEntityRepository postalLocationEntityRepository;

    public JpaPostalLocationService(final PostalLocationEntityRepository postalLocationEntityRepository) {
        this.postalLocationEntityRepository = postalLocationEntityRepository;
    }

    public PostalLocation getPostalLocation(final String postalCode) {
        final PostalLocationEntity postalLocationEntity = postalLocationEntityRepository.getByPostalCode(postalCode);

        validatePostalCodeExists(postalCode, postalLocationEntity);

        final Location location = aLocation(postalLocationEntity.getLatitude(), postalLocationEntity.getLongitude());
        return aPostalLocation(postalLocationEntity.getPostalCode(), location);
    }

    private void validatePostalCodeExists(final String postalCode, final PostalLocationEntity postalLocationEntity) {
        if (postalLocationEntity == null) {
            throw new PostalCodeNotFoundException(postalCode);
        }
    }
}
