package com.hainet.spring.boot.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBatchApplication {

    // --spring.profiles.active=foo
    public static void main(final String[] args) {
        SpringApplication.run(SpringBootBatchApplication.class, args);
    }
}
