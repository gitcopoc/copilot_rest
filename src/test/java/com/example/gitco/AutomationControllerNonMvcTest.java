package com.example.gitco;

import com.example.gitco.controller.AutomationController;
import com.example.gitco.model.AutoCopilot;
import com.example.gitco.service.AutomationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AutomationControllerNonMvcTest {

    @Autowired
    private AutomationService service;

    @Autowired
    AutomationController controller;
    //private final AutomationService service = Mockito.mock(AutomationService.class);
    //  private final AutomationController controller = new AutomationController(service);

    @Test
    public void testGetDataFromRepos() {
        AutoCopilot autoCopilot = new AutoCopilot();
        autoCopilot.setId(1L);
        autoCopilot.setName("Test");
        autoCopilot.setEmail("test@example.com");

        when(service.getAllAutomatedCode()).thenReturn(autoCopilot);

        ResponseEntity<Object> response = controller.getDataFromRepos();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(autoCopilot, response.getBody());
    }
}