package com.webster.springboot.cruddemo.dao;

import com.webster.springboot.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    public List<Student> findAll();

    public Student findById(int id);

    public void save(Student student);

    public void deletebyId(int id);


}
