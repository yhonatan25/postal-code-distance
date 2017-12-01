package org.yhonatan.practice.postal.code.distance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yhonatan.practice.postal.code.distance.core.DistanceCalculator;
import org.yhonatan.practice.postal.code.distance.core.HaversineDistanceCalculator;
import org.yhonatan.practice.postal.code.distance.core.PostalLocationFacade;
import org.yhonatan.practice.postal.code.distance.core.PostalLocationService;
import org.yhonatan.practice.postal.code.distance.service.JpaPostalLocationService;
import org.yhonatan.practice.postal.code.distance.jpa.repository.PostalLocationEntityRepository;

@Configuration
public class PostalLocationConfig {

    @Bean
    public PostalLocationFacade postalLocationFacade(final PostalLocationService postalLocationService, final DistanceCalculator distanceCalculator) {
        return new PostalLocationFacade(postalLocationService, distanceCalculator);
    }

    @Bean
    public PostalLocationService postalLocationService(final PostalLocationEntityRepository postalLocationEntityRepository) {
        return new JpaPostalLocationService(postalLocationEntityRepository);
    }

    @Bean
    public DistanceCalculator distanceCalculator() {
        return new HaversineDistanceCalculator();
    }

}
