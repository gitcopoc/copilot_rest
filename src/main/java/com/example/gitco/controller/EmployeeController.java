package com.example.gitco.controller;

import com.example.gitco.model.Employee;
import com.example.gitco.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService service;

    EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    List<Employee> all() {
        return service.getAllEmployees();
    }
}