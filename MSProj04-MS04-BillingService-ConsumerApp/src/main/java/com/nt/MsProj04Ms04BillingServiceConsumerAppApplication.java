package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MsProj04Ms04BillingServiceConsumerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj04Ms04BillingServiceConsumerAppApplication.class, args);
	}

}
