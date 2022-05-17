package com.springcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach{

    @Value("${obj.team}")
    private String team;

    @Value("${obj.contact}")
    private double contact;

    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getTeam() {
        return team;
    }

//    public void setTeam(String team) {
//        this.team = team;
//    }

    public double getContact() {
        return contact;
    }

//    public void setContact(double contact) {
//        this.contact = contact;
//    }

    @Override
    public String getDailyWorkut() {
        return "swim for 2hrs daily";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
