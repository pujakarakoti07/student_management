package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo repo;
    public String addStudent(Student student) {
        repo.save(student);
        return "Student registered successfully";
    }

    public Optional<Student> getStudent(Integer id) {
        Optional<Student> student1 = repo.findById(id);
        return student1;
    }
    public List<Student> getStudent() {
        return repo.findAll();
    }

    public List<Student> getAllStudents() {
        List<Student> students = repo.findAll();
        return students;
    }


    public void UpdateStudent(int id, Student updatedStudent) {
        repo.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setContact(updatedStudent.getContact());
                    student.setAddress(updatedStudent.getAddress());
                    student.setPincode(updatedStudent.getPincode());
                    Student savedStudent = repo.save(student);
                    return ResponseEntity.ok(savedStudent);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
