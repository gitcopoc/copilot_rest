package com.example.gitco.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private Long id;
    private String name;
    private String email;

    // getters and setters
}