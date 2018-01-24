package com.hainet.spring.boot.batch.controller;

import com.hainet.spring.boot.batch.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("foo")
@RequiredArgsConstructor
public final class FooController extends BaseController {

    @Override
    public int run() {
        System.out.println("This is foo implementation section.");

        return 0;
    }
}
