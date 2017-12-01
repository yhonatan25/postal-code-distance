package org.yhonatan.practice.postal.code.distance.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yhonatan.practice.postal.code.distance.jpa.entity.DistanceRequestLogEntity;

import java.util.List;

public interface DistanceRequestLogEntityRepository extends JpaRepository<DistanceRequestLogEntity, Long> {

    List<DistanceRequestLogEntity> findByInitialPostalCodeOrFinalPostalCode(final String initialPostalCode, final String finalPostalCode);
}
