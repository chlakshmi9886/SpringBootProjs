package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsProj05Ms05ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj05Ms05ConfigServerApplication.class, args);
	}

}
