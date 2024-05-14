package com.example.gitco;

import com.example.gitco.controller.AutomationController;
import com.example.gitco.model.AutoCopilot;
import com.example.gitco.service.AutomationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AutomationController.class)
public class AutomationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AutomationService service;

    @Test
    public void testGetDataFromRepos() throws Exception {
        AutoCopilot autoCopilot = new AutoCopilot();
        autoCopilot.setId(1L);
        autoCopilot.setName("Test");
        autoCopilot.setEmail("test@example.com");

        when(service.getAllAutomatedCode()).thenReturn(autoCopilot);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/automation/getData")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Test\",\"email\":\"test@example.com\"}"));
    }

    @Test
    public void testSaveAutoCopilot() throws Exception {
        AutoCopilot autoCopilot = new AutoCopilot();
        autoCopilot.setName("Test");
        autoCopilot.setEmail("test@example.com");

        AutoCopilot savedAutoCopilot = new AutoCopilot();
        savedAutoCopilot.setId(1L);
        savedAutoCopilot.setName("Test");
        savedAutoCopilot.setEmail("test@example.com");

        when(service.saveAutoCopilot(any(AutoCopilot.class))).thenReturn(savedAutoCopilot);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/automation/saveData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test\",\"email\":\"test@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Test\",\"email\":\"test@example.com\"}"));
    }
}
