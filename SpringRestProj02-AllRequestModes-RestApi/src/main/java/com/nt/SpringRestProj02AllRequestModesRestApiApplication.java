package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.nt.controller.EmployeeOperationsController;

@SpringBootApplication
@ComponentScan(basePackageClasses =  EmployeeOperationsController.class)
public class SpringRestProj02AllRequestModesRestApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestProj02AllRequestModesRestApiApplication.class, args);
	}
	
	 @Override
	   protected SpringApplicationBuilder configure(SpringApplicationBuilder 
	   application) {
	      return application.sources(SpringRestProj02AllRequestModesRestApiApplication.class);
	   }


}
