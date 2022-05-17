package com.webster.springboot.cruddemo.service;

import com.webster.springboot.cruddemo.dao.StudentRepository;
import com.webster.springboot.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student findById(int id) {
        Optional<Student> result = studentRepository.findById(id);

        Student theStudent = null;
        if (result.isPresent()){
            theStudent =  result.get();
        }
        else {
            throw new RuntimeException("Student not found with id =" + id);
        }

        return theStudent;
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deletebyId(int id) {
        studentRepository.deleteById(id);
    }
}
