package com.tahamert.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.tahamert")
@ComponentScan("com.tahamert")
@EnableJpaRepositories("com.tahamert")
public class SprinDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprinDataJpaApplication.class, args);
    }

}
