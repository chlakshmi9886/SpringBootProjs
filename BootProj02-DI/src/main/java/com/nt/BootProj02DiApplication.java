package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
public class BootProj02DiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootProj02DiApplication.class, args);
		Vehicle veh = ctx.getBean("vehicle",Vehicle.class);
		veh.journey("Hyd","BZA");
		((ConfigurableApplicationContext)ctx).close();
	}

}
