package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.entity.Actor;
import com.nt.service.ActorServiceImpl;

@SpringBootApplication
public class BootProjJpa1CrudRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootProjJpa1CrudRepositoryApplication.class, args);

	}

}
