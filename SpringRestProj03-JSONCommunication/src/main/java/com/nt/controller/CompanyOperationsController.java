package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;

@RestController
@RequestMapping("/company/api")
public class CompanyOperationsController {

	@GetMapping("/show")
	public ResponseEntity<Company> showDetails(){
		System.out.println("CompanyOperationsController.showDetails()");
		Company company = new Company("HCL",
				"Hyderabad",
				500000000.50,
				"IT");
		System.out.println("Ccompany object created");
		return new ResponseEntity<Company>(company,HttpStatus.OK);
	}
}
