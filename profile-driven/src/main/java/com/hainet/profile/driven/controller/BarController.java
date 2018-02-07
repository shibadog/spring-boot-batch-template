package com.hainet.profile.driven.controller;

import com.hainet.profile.driven.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("bar")
@RequiredArgsConstructor
public final class BarController extends BaseController {

    @Override
    public int run() {
        System.out.println("This is bar implementation section.");

        return 0;
    }
}
