package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Employee;

@Controller
public class EmployeeReportController {

	//Data Rendering Techniques
	//1. Passing simple values
	
	@GetMapping("/send")
	public String sendDatausingSimpleValues(Map<String, Object> map) {
		//put simple values to model class object
		map.put("name", "Nag");
		map.put("age", 30);
		return "show_data";
	}
	//2. Passing collections and arrays
	
	@GetMapping("/sendcollections")
	public String sendCollectionData(Map<String, Object> map) {
		//put arrays and collections as model attribute values
		map.put("favColors", new String[] {"Red", "Yellow" , "Blue", "Green"});
		map.put("nickNames", List.of("Chinni","Bunny", "Sunny"));
		map.put("phonenumbers", Set.of(9999999l,888888l,7777777));
		map.put("iddetails", Map.of("aadhar",89898989,"voterid",25252525));
		return "showcollections";
	}
	
	//3. Passing Model object

	
	@GetMapping("/report")
	public String showReport(Map<String,Object> map) {
		
		Employee emp = new Employee();
		emp.setEno("1001");
		emp.setEname("Raja");
		emp.setSalary(90000.5);
		emp.setIsVaccinated("Yes");
		map.put("empinfo", emp);
		return "show_report";
	}
	
	//4. Passing collection of Model class objects
	@GetMapping("/report1")
	public String showReport1(Map<String, Object> map) {
		
		List<Employee> emp = List.of(new Employee("1002","Rajesh",75000.5,"Yes"),
									new Employee("1003","Kajesh",75000.5,"No"),
									new Employee("1004","Jajesh",75000.5,"Yes"),
									new Employee("1005","Majesh",75000.5,"No"),
									new Employee("1006","Najesh",75000.5,"Yes"));
		map.put("empinfo", emp);
		return "show_report1";
	}
}
