package com.example.StudentManagementSystem.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentManagementSystem.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByYearOfEnrolment(String yearOfEnrollment);
    String findDepartmentById(long id);
    void removeStudentbyYear(String yearOfEnrollment);
}

