package com.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

    public static void main(String[] args) {

        //Load Spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieving Beans from container
        Employee employee = context.getBean("emp", Employee.class);
        Employee employee1 = context.getBean("emp", Employee.class);

        //calling methods of Employee
        System.out.println(employee);
        System.out.println(employee1);

        System.out.println(employee == employee1);

        //closing context
        context.close();
    }
}
