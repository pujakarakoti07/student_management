package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.repo.StudentRepo;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService service;
    @Autowired
    StudentRepo repo;

    @GetMapping("/Student/info")
        public List<Student> getAllStudents(){
            return service.getStudent();
        }

    @PostMapping("/register")
    public void RegisterStudent(@RequestBody Student student){
        service.addStudent(student);
    }
    @GetMapping("/Student/info/{id}")
    public Optional<Student> getStudentInfo(@PathVariable int id){
        return service.getStudent(id);
    }


    @DeleteMapping("/Student/{id}")
    public void deleteUser(@PathVariable int id) {
        repo.findById(id)
                .map(Student -> {
                    repo.delete(Student);
                    return null;
                });
    }
    @PutMapping("/Student/update")
    public void updateStudent(@RequestBody int id){
        service.UpdateStudent(id);
    }
}
