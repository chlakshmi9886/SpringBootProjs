package com.nt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj09LayeredAppProfilesPropertiesApplication {

	@Autowired
	private Environment env;
	
	@Bean(name="c3p0ds")
	@Profile("test")
	public ComboPooledDataSource createC3P0DS() throws Exception{
		
		System.out.println("BootProj09LayeredAppProfilesPropertiesApplication.createC3P0DS()");
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		ds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		ds.setUser(env.getRequiredProperty("spring.datasource.username"));
		ds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		
		ds.setInitialPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.minsize")));
		ds.setMaxPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.maxsize")));
		return ds;
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootProj09LayeredAppProfilesPropertiesApplication.class, args);
		PayrollOperationsController controller =ctx.getBean("pyrlController", PayrollOperationsController.class);
		try {
		List<Employee> list = controller.getEmployeeByDesignations("CLERK", "MANAGER1", "SALESMAN");
		
		list.forEach(emp->System.out.println(emp));
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		((ConfigurableApplicationContext)ctx).close();		
	}
}
