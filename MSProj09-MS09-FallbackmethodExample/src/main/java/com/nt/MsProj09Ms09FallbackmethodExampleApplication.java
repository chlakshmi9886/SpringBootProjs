package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class MsProj09Ms09FallbackmethodExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj09Ms09FallbackmethodExampleApplication.class, args);
	}

}
