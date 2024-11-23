package com.example.StudentManagementSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "Department",nullable = false)
    private String department;
    @Column(name = "YearOfEnrollment",nullable = false)
    private String yearOfEnrolment;
}
