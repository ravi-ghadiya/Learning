package com.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee employee = (Employee) context.getBean("employee");

        System.out.println(employee);

        System.out.println(employee.getPerson().getPrimaryLanguage());

        context.close();

    }
}
