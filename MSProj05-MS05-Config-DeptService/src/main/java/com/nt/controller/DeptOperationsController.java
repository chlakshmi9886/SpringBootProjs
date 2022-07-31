package com.nt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DeptOperationsController {

	@Value("${dbuser}")
	private String dbusername;
	@Value("${dbpwd}")
	private String dbpassword;

	@GetMapping("/show")
	public ResponseEntity<String> showEmployeeDetails(){
		return new ResponseEntity<String>("Showing employee details : "+dbusername + " -- " +dbpassword,HttpStatus.OK);
	}
}
