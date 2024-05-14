package com.example.gitco.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "autocopilot", schema = "gitpocsch")
@Data
public class AutoCopilot {
    @Id
    private Long id;
    private String name;
    private String email;

    // getters and setters
}