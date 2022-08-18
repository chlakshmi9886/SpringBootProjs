package com.nt.controller;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeOperationsController {
	
	@GetMapping("/all")
	public ResponseEntity<String> getAllEmployees(){
		System.out.println("EmployeeOperationsController.getAllEmployees()");
		return new ResponseEntity<String>("All employee retrieved", HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerEmployees(){
		System.out.println("EmployeeOperationsController.registerEmployees()");
		return new ResponseEntity<String>("Employee registration successfull.",HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(){
		System.out.println("EmployeeOperationsController.updateEmployee()");
		return new ResponseEntity<String>("put mapping - update employee",HttpStatus.OK);
	}
	
	@PatchMapping("/updateEmail")
	public ResponseEntity<String> updateEmployeeEmail(){
		System.out.println("EmployeeOperationsController.updateEmployeeEmail()");
		return new ResponseEntity<String>("patch mapping - employee mail updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee(){
		System.out.println("EmployeeOperationsController.deleteEmployee()");
		return new ResponseEntity<String>("delete mapping - employee deleted", HttpStatus.OK);
	}

}
