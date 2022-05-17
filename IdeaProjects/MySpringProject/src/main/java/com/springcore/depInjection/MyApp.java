package com.springcore.depInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

    public static void main(String args[]){

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        System.out.println("===============================================");

        Example example = (Example) context.getBean("example");

        System.out.println("===============================================");

        System.out.println(example);

        context.registerShutdownHook();
    }
}
