package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeOperationsController {

	@GetMapping("/show")
	public ResponseEntity<String> getEmployeeInfo() {
		return new ResponseEntity<String>("Showing employeee details",HttpStatus.OK);
	}
}
