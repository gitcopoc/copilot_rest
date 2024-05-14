package com.example.gitco.controller;

import com.example.gitco.model.AutoCopilot;
import com.example.gitco.service.AutomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (produces =  MediaType.APPLICATION_JSON_VALUE, value = "/api/v1/automation")
public class AutomationController {
   @Autowired
   AutomationService service;

    @GetMapping("/getData")
    public ResponseEntity<Object> getDataFromRepos() {
        AutoCopilot autoCopilotList = service.getAllAutomatedCode();
        return ResponseEntity.ok(autoCopilotList);
    }

    @PostMapping("/saveData")
    public ResponseEntity<AutoCopilot> saveAutoCopilot(@RequestBody AutoCopilot autoCopilot) {
        AutoCopilot savedAutoCopilot = service.saveAutoCopilot(autoCopilot);
        return ResponseEntity.ok(savedAutoCopilot);
    }


}