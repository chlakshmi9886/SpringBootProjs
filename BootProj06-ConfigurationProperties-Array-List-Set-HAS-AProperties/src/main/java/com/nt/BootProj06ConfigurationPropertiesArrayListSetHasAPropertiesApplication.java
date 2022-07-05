package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.model.Employee;

@SpringBootApplication
public class BootProj06ConfigurationPropertiesArrayListSetHasAPropertiesApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx=
		SpringApplication.run(BootProj06ConfigurationPropertiesArrayListSetHasAPropertiesApplication.class, args);
		
		Employee emp = ctx.getBean("emp",Employee.class);
		System.out.println("employee details :: " +emp);
		((ConfigurableApplicationContext)ctx).close();
	}

}
