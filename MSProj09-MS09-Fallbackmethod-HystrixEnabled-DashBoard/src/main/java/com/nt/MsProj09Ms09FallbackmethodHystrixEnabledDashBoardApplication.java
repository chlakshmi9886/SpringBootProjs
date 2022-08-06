package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class MsProj09Ms09FallbackmethodHystrixEnabledDashBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj09Ms09FallbackmethodHystrixEnabledDashBoardApplication.class, args);
	}

}
