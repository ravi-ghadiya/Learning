package com.webster.springboot.cruddemo.dao;

import com.webster.springboot.cruddemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// @RepositoryRestResource(path = "users")
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
