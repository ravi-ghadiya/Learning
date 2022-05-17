package com.webster.beanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Programmer {
    private List<String> programmingLangs;
    private Set<String> phones;
    private Map<String, Double> experience;
    private double age;

    public Programmer() {
    }

    public List<String> getProgrammingLangs() {
        return programmingLangs;
    }

    public void setProgrammingLangs(List<String> programmingLangs) {
        this.programmingLangs = programmingLangs;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public Map<String, Double> getExperience() {
        return experience;
    }

    public void setExperience(Map<String, Double> experience) {
        this.experience = experience;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "programmingLangs=" + programmingLangs +
                ", phones=" + phones +
                ", experience=" + experience +
                ", age=" + age +
                '}';
    }

    @PostConstruct
    public void init() {
        System.out.println("Programmer: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Programmer: destroy method");
    }
}
