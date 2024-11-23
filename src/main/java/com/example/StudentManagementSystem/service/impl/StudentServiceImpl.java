package com.example.StudentManagementSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.StudentRepository;
import com.example.StudentManagementSystem.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public Student updateStudent(Student student, long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearOfEnrolment(student.getYearOfEnrolment());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentByYearOfEnrollment(String yearOfEnrollment) {
        //studentRepository.findByYearOfEnrolment(yearOfEnrollment).orElseThrow(() -> new RuntimeException("Student not found"));
        return studentRepository.findByYearOfEnrolment(yearOfEnrollment);
    }

    @Override
    public String getStudentDepartmentById(long id) {
        studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return studentRepository.findDepartmentById(id);
    }

    @Override
    public void deleteByYearOfEnrollment(String yearOfEnrollment) {
        //studentRepository.findByYearOfEnrolment(yearOfEnrollment).orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.removeStudentbyYear(yearOfEnrollment);
    }

}
