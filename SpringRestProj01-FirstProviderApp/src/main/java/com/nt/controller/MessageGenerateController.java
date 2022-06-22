package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageGenerateController {

	
	@GetMapping("/wish")
	public ResponseEntity<String> showMessage(){
		String msg = null;
		LocalDateTime ldt = LocalDateTime.now();
		int hour = ldt.getHour();
		if(hour <12)
			msg = "Good Morning.  Time is : " + ldt;
		else if(hour < 16)
			msg = "Good AfterNoon.  Time is : " + ldt;
		else if(hour <20)
			msg = "Good Evening.  Time is : " + ldt;
		else
			msg = "Good Night.  Time is : " + ldt;
		ResponseEntity< String> entity = new ResponseEntity<String>(msg, HttpStatus.OK);
		return entity;
	}
}