package com.example.gitco.service;

import com.example.gitco.model.AutoCopilot;

public interface AutomationService {
    AutoCopilot getAllAutomatedCode();

    AutoCopilot saveAutoCopilot(AutoCopilot autoCopilot);
}