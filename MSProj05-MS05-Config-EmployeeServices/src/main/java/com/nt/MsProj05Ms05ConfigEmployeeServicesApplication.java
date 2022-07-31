package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsProj05Ms05ConfigEmployeeServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj05Ms05ConfigEmployeeServicesApplication.class, args);
	}

}
