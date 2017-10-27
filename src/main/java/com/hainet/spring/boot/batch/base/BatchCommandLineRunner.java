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
            throw new RuntimeException("Specify a target controller. (e.g. --controller=ConcreteController)");
        }

        getConcreteController(concreteControllerName).execute(args);
    }

    private FunctionalController getConcreteController(String concreteControllerName) {
        try {
            return context.getBean(uncapitalize(concreteControllerName), FunctionalController.class);
        } catch (BeanNotOfRequiredTypeException e) {
            throw new RuntimeException("The specified controller isn't implementation of FunctionalController.", e);
        } catch (BeansException e) {
            throw new RuntimeException("The specified controller isn't in Spring container.", e);
        }
    }

    private String uncapitalize(String str) {
        return new StringBuilder()
                .append(str.substring(0, 1).toLowerCase())
                .append(str.substring(1)).toString();
    }
}
