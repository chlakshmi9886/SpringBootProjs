package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsProj12PaymentServiceMsApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj12PaymentServiceMsApiGateWayApplication.class, args);
	}

}
