package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj12LayeredAppRunnersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootProj12LayeredAppRunnersApplication.class, args);
	}
}
