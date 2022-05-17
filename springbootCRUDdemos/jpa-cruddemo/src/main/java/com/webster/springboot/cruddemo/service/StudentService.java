package com.webster.springboot.cruddemo.service;

import com.webster.springboot.cruddemo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public List<Student> findAll();

    public Student findById(int id);

    public void save(Student student);

    public void deletebyId(int id);
}
