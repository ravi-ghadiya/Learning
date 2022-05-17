package com.webster.beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean {
    int EmpId;
    String EmpName;
    Programmer programmer;

    public Employee() {

    }

    public Employee(int empId, String empName, Programmer programmer) {
        EmpId = empId;
        EmpName = empName;
        this.programmer = programmer;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmpId=" + EmpId +
                ", EmpName='" + EmpName + '\'' +
                ", programmer=" + programmer +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Employee: destroy: called before Destruction of Bean!!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Employee: afterPropertiesSet: called after Bean properties set!!");

    }
}
