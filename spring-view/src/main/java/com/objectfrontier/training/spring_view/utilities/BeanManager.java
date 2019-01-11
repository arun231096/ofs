package com.objectfrontier.training.spring_view.utilities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanManager {

    private static ApplicationContext applicationContext;

    static {
        applicationContext = new ClassPathXmlApplicationContext("config.xml");
    }

    public static <T> T getBean (Class<T> type) {
        return applicationContext.getBean(type);
    }
}