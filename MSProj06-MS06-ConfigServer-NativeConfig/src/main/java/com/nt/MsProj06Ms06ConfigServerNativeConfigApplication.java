package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsProj06Ms06ConfigServerNativeConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj06Ms06ConfigServerNativeConfigApplication.class, args);
	}

}
