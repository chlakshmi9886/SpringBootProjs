package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/api")
public class StudentMgmtController {

	@GetMapping("/report/{sno}/{sname}")
	public ResponseEntity<String> showReport1(@PathVariable("sno") Integer no,
												@PathVariable(required=false) String sname){
		System.out.println(no + "  ------ " +sname);
		return new ResponseEntity<String>("show report 1",HttpStatus.OK);
	}
	@GetMapping("/report/{sno}/sname")
	public ResponseEntity<String> showReport2(@PathVariable("sno") Integer no,
												@PathVariable(required=false) String sname){
		System.out.println(no + "  ------ " +sname);
		return new ResponseEntity<String>("show report 2",HttpStatus.OK);
	}
	@GetMapping("/report/sno/{sname}")
	public ResponseEntity<String> showReport3(@PathVariable("sno") Integer no,
												@PathVariable(required=false) String sname){
		System.out.println(no + "  ------ " +sname);
		return new ResponseEntity<String>("show report 3",HttpStatus.OK);
	}
	
	@GetMapping("/report/sno/sname")
	public ResponseEntity<String> showReport4(@PathVariable("sno") Integer no,
												@PathVariable(required=false) String sname){
		System.out.println(no + "  ------ " +sname);
		return new ResponseEntity<String>("show report 4",HttpStatus.OK);
	}
	@GetMapping("/report/101/raja")
	public ResponseEntity<String> showReport5(@PathVariable(name ="sno",required=false) Integer no,
												@PathVariable(required=false) String raja){
		//System.out.println(no + "  ------ " +sname);
		return new ResponseEntity<String>("show report 5",HttpStatus.OK);
	}
	
	
	
}
