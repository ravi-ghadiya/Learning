package com.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component()
public class Employee {
    @Value("${obj.empId}")
    private int empId;
    @Value("${obj.city}")
    private String city;

    @Autowired
    private Person person;


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        System.out.println("setting person>>>>>>>>");
        this.person = person;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", city='" + city + '\'' +
                ", person=" + person +
                '}';
    }
}
