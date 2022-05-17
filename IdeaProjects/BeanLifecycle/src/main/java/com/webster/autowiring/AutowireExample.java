package com.webster.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireExample {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        Emp employee = context.getBean("emp", Emp.class);

        System.out.println(employee);
    }
}
