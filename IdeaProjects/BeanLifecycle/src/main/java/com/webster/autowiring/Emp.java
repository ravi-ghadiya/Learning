package com.webster.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class Emp {
    @Value("222")
    private int empid;
    @Value("Ram")
    private String empname;
    @Autowired
    private Department empdept;
    @Value("#{phoneNos}")
    private Set<String> phones;
    @Value("#{progLangs}")
    private List<String> programmingLangs;
    @Value("#{exp}")
    private Map<String, Double> experiences;


    public Emp() {
    }


//    public Emp(Department empdept) {
//        this.empdept = empdept;
//    }

//    public Set<String> getPhones() {
//        return phones;
//    }
//
//    public void setPhones(Set<String> phones) {
//
//        this.phones = phones;
//    }
//
//    public List<String> getProgrammingLangs() {
//        return programmingLangs;
//    }
//
//    public void setProgrammingLangs(List<String> programmingLangs) {
//        this.programmingLangs = programmingLangs;
//    }
//
//    public Map<String, Double> getExperiences() {
//        return experiences;
//    }
//
//    public void setExperiences(Map<String, Double> experiences) {
//        this.experiences = experiences;
//    }
//
//
//
//    public int getEmpid() {
//        return empid;
//    }
//
//    public void setEmpid(int empid) {
//        this.empid = empid;
//    }
//
//    public String getEmpname() {
//        return empname;
//    }
//
//    public void setEmpname(String empname) {
//        this.empname = empname;
//    }
//
//    public Department getEmpdept() {
//        return empdept;
//    }
//
//
//    public void setEmpdept(Department empdept) {
//        this.empdept = empdept;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "Empid=" + empid +
                ", Empname='" + empname + '\'' +
                ", Empdept=" + empdept +
                ", phones=" + phones +
                ", programmingLangs=" + programmingLangs +
                ", experiences=" + experiences +
                '}';
    }
}
