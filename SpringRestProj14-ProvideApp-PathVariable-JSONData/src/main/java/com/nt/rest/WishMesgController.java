package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Tourist;

@RestController
@RequestMapping("/wish/api")
public class WishMesgController {

	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
		
		System.out.println("WishMesgController.registerTourist()");
		return new ResponseEntity<String>("tourist info :: " + tourist.toString(),HttpStatus.CREATED);
	}
}
