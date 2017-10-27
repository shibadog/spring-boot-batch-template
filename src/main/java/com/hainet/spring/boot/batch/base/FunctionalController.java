package com.hainet.spring.boot.batch.base;

@FunctionalInterface
public interface FunctionalController {

    void execute(String... args);
}
