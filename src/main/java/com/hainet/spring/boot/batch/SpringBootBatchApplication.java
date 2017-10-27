package com.hainet.spring.boot.batch;

import com.hainet.spring.boot.batch.base.FunctionalController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootBatchApplication {

    // Command line args: --controller=ConcreteController
    public static void main(String[] args) {
        SpringApplication.run(SpringBootBatchApplication.class, args);
    }

    @Bean
    public FunctionalController noopController() {
        return (args) -> {};
    }
}
