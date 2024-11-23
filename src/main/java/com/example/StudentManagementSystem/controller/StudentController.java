package com.example.StudentManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.service.StudentService;

@RestController
@RequestMapping("/api/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student),HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId) {
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(student,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully",HttpStatus.OK);
    }
}