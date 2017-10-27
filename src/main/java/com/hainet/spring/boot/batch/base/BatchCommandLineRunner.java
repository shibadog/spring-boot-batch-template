package com.hainet.spring.boot.batch.base;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BatchCommandLineRunner implements CommandLineRunner {

    private ConfigurableApplicationContext context;
    private String concreteControllerName;

    @Autowired
    public BatchCommandLineRunner(
            ConfigurableApplicationContext context,
            @Value("${controller}") String concreteControllerName) {
        this.context = context;
        this.concreteControllerName = concreteControllerName;
    }

    @Override
    public void run(String... args) {
        if (concreteControllerName == null || concreteControllerName.length() == 0) {
            throw new RuntimeException("起動対象を指定して下さい。(e.g. --controller=ConcreteController)");
        }

        getConcreteController(concreteControllerName).execute(args);
    }

    private FunctionalController getConcreteController(String concreteController) {
        try {
            return context.getBean(uncapitalize(concreteController), FunctionalController.class);
        } catch (BeanNotOfRequiredTypeException e) {
            throw new RuntimeException("起動対象がBatchControllerの実装ではありません。", e);
        } catch (BeansException e) {
            throw new RuntimeException("起動対象がSpringコンテナにBean登録されていません。", e);
        }
    }

    private String uncapitalize(String str) {
        return new StringBuilder()
                .append(str.substring(0, 1).toLowerCase())
                .append(str.substring(1)).toString();
    }
}
