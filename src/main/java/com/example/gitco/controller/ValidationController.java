
package com.example.gitco.controller;


import com.example.gitco.service.ValidateProductDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(produces =  MediaType.APPLICATION_JSON_VALUE, value = "/api/v1/automation")

public class ValidationController {


	@Autowired
	ValidateProductDataService productDataService;
	

	
	@GetMapping(path = "/validation/trigger")
	public boolean triggerValidation() {
		return productDataService.validate();
	}
	

}
