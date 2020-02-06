package com.ygr.cts.ConductTrackingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * @author yagnaguru.r
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.ygr.cts")
@EntityScan(basePackages = {"com.ygr.cts.domain"})
@EnableJpaRepositories("com.ygr.cts.service")
public class ConductTrackingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConductTrackingSystemApplication.class, args);
    }

}
