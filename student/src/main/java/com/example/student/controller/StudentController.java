package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService service;
    @PostMapping("/register")
    public void RegisterStudent(@RequestBody Student student){
        service.addStudent(student);
    }
    @GetMapping("/Student/info/{id}")
    public Optional<Student> getStudentInfo(@PathVariable Integer id){
        return service.getStudent(id);
    }
}
