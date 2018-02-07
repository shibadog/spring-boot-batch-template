package com.hainet.profile.driven.base;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("!test")
public final class BatchCommandLineRunner implements CommandLineRunner {

    private final ControllerInterface controller;

    @Override
    public void run(String[] args) {
        controller.execute(args);
    }
}
