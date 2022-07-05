package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.Customer;

@SpringBootApplication
public class BootProj07YamlApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=
		SpringApplication.run(BootProj07YamlApplication.class, args);
		Customer cust = ctx.getBean("cust",Customer.class);
		System.out.println(cust);
		((ConfigurableApplicationContext)ctx).close();
	}

}
