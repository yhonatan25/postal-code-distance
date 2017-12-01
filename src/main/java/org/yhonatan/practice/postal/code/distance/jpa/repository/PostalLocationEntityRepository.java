package org.yhonatan.practice.postal.code.distance.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yhonatan.practice.postal.code.distance.jpa.entity.PostalLocationEntity;

public interface PostalLocationEntityRepository extends JpaRepository<PostalLocationEntity, Long>{

    PostalLocationEntity getByPostalCode(final String postalCode);

}
