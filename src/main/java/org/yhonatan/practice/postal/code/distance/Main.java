package org.yhonatan.practice.postal.code.distance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Main {
    public static final void main(final String [] args){
        SpringApplication.run(Main.class);
    }

}
