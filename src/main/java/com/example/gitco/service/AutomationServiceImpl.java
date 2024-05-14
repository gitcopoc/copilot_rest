package com.example.gitco.service;

import com.example.gitco.model.AutoCopilot;
import com.example.gitco.repository.AutoCopilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutomationServiceImpl implements AutomationService {

    @Autowired
    private AutoCopilotRepository repository;

    @Override
    public AutoCopilot getAllAutomatedCode() {
        return repository.findById(Long.valueOf(1)).orElse(new AutoCopilot());
    }
}