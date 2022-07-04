package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@Component
public class LayeredAppTestRunner implements CommandLineRunner {

	@Autowired
	private PayrollOperationsController controller;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			List<Employee> list = controller.getEmployeeByDesignations("CLERK", "MANAGER1", "SALESMAN");
			
			list.forEach(emp->System.out.println(emp));
			
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}

	public LayeredAppTestRunner() {
		System.out.println("LayeredAppTestRunner.LayeredAppTestRunner()--o-param constructor");
	}

}
