package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsProj07Ms07ConfigDeptServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj07Ms07ConfigDeptServicesApplication.class, args);
	}

}
