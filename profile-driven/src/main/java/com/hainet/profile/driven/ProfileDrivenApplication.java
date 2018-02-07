package com.hainet.profile.driven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfileDrivenApplication {

    // --spring.profiles.active=foo
    public static void main(final String[] args) {
        SpringApplication.run(ProfileDrivenApplication.class, args);
    }
}
