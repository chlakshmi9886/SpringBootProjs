package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Employee;

@RestController
@RequestMapping("/employee/api")
public class EmployeeOperationsController {

	@PostMapping("/register")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee emp){
		
		return new ResponseEntity<Employee> (emp, HttpStatus.CREATED);
	}
}
