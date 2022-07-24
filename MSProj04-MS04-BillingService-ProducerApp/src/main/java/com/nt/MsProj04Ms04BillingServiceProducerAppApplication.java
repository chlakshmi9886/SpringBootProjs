package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsProj04Ms04BillingServiceProducerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj04Ms04BillingServiceProducerAppApplication.class, args);
	}

}
