package com.webster.beanlifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

    public static void main(String[] args) {
        AbstractApplicationContext context= new ClassPathXmlApplicationContext("config.xml");

        Employee employee= (Employee) context.getBean("employee");

        System.out.println(employee);

        context.registerShutdownHook();

    }
}
