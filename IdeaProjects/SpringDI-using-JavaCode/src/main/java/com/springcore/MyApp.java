package com.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SwimCoach coach = (SwimCoach) context.getBean("swimCoach");

        System.out.println(coach.getDailyWorkut());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getTeam());
        System.out.println(coach.getContact());


        context.close();
    }
}
