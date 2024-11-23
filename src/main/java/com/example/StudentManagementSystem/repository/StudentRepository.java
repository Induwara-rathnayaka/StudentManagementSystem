package com.example.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentManagementSystem.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    // JPA provides basic CRUD operations here
}

