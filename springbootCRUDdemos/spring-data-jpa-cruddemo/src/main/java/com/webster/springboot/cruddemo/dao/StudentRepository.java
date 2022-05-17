package com.webster.springboot.cruddemo.dao;

import com.webster.springboot.cruddemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
