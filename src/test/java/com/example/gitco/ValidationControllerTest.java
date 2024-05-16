package com.example.gitco;

import com.example.gitco.service.ValidateProductDataService;
import com.example.gitco.controller.ValidationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ValidationController.class)
public class ValidationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ValidateProductDataService service;

    @Test
    public void testTriggerValidation() throws Exception {
        when(service.validate()).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/automation/validation/trigger"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}