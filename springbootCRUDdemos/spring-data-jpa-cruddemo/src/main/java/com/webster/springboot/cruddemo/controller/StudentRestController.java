package com.webster.springboot.cruddemo.controller;

import com.webster.springboot.cruddemo.entity.Student;
import com.webster.springboot.cruddemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        Student student = studentService.findById(studentId);
        if (student == null){
            throw new RuntimeException("Student not found with id - " + studentId);
        }
        return student;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        student.setId(0);
        studentService.save(student);
        return student;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        studentService.save(student);
        return student;
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId){
        Student student = studentService.findById(studentId);
        if (student==null){
            throw new RuntimeException("student does not exist with id: " + studentId);
        }

        studentService.deletebyId(studentId);

        return "Student has been deleted with id: " + studentId;
    }
}
