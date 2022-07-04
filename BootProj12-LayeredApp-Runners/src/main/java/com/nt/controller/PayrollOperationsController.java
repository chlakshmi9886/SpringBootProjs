package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@Controller("pyrlController")
public class PayrollOperationsController {
	
	@Autowired
	private IEmployeeService service;
	
	
	
	public PayrollOperationsController() {
		System.out.println("PayrollOperationsController.PayrollOperationsController()");
	}



	public List<Employee> getEmployeeByDesignations(String desg1, String desg2, String desg3) throws Exception {
	
		List<Employee> list = service.fetchEmployeeByDesignations(desg1, desg2, desg3);
		return list;
	}
}
