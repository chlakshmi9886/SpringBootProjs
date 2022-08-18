package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/api")
public class CustomerOperationsController {
	
	@GetMapping("/report")
	public ResponseEntity<String> showReport(@RequestParam(required=false) Integer no,
			@RequestParam(required=false) Integer id, 
			@RequestParam (required=false) String cname){
		System.out.println(no +"  "+ id +"  "+cname);
		return new ResponseEntity<String>(no +"  "+ id +"  "+cname,HttpStatus.OK);
	}

}
