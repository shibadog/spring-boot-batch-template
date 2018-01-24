package com.hainet.spring.boot.batch.base;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public final class BatchCommandLineRunner implements CommandLineRunner {

    private final ControllerInterface controller;

    @Override
    public void run(String[] args) {
        controller.execute(args);
    }
}
