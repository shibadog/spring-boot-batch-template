package com.hainet.spring.boot.batch.base;

public abstract class BaseController implements FunctionalController {

    @Override
    public void execute(String... args) {
        startup();
        int result = run();
        shutdown();
    }

    private void startup() {
        // 前処理
    }

    public abstract int run();

    private void shutdown() {
        // 後処理
    }
}
