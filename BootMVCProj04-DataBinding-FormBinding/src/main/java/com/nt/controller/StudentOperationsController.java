package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationsController {

	//Data binding can be done in 2 ways
	//1. Passing form data to controller class handler method as model class object
	//using @ModelAttribute(-) annotation. Form Binding
	//2. Passing hyperlink supplied additional request parameter values to handler method params
	//through dispatcher servlet using @RequestParam() annotation. Param Binding
	
	//In this example we will see the form binding.
	
	@GetMapping
	public String showHome() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String showForm() {
		return "studentregister";
	}
	
	@PostMapping("/register")
	public String processStudent(Map<String, Object> map,
								@ModelAttribute("stud") Student st) {
		//generate result
		String grade = null;
		if(st.getAverage()>75) {
			grade= "First Class";
		}
		else if(st.getAverage()> 65) {
			grade = "Second Class";
		}
		else if(st.getAverage()>35) {
			grade = "Pass";
		}
		else {
			grade = "Fail"; 
		}
		
		//keep results in model map
		map.put("result", grade);
		return "show_result";
	}
}
