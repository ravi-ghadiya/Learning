package com.webster.autowiring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("empdept")
public class Department {
    @Value("101")
    private int deptid;
    @Value("CSE")
    private String deptname;

    @Value("#{supervisors}")
    private ArrayList<String> deptsupervisors;

    public ArrayList<String> getDeptsupervisors() {
        return deptsupervisors;
    }

    public void setDeptsupervisors(ArrayList<String> deptsupervisors) {
        this.deptsupervisors = deptsupervisors;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptid=" + deptid +
                ", deptname='" + deptname + '\'' +
                ", supervisors=" + deptsupervisors +
                '}';
    }
}
