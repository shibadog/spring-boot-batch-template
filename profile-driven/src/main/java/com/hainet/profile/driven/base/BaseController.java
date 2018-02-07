package com.hainet.profile.driven.base;

public abstract class BaseController implements ControllerInterface {

    @Override
    public void execute(final String[] args) {
        this.startup();
        final int result = this.run();
        this.shutdown();

        System.out.println("Result: " + result);
    }

    private void startup() {
        System.out.println("This is startup section.");
    }

    public abstract int run();

    private void shutdown() {
        System.out.println("This is shutdown section.");
    }
}
