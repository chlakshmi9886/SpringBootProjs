package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.WishMessageGenerator;

@SpringBootApplication
public class BootProj01BasicDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootProj01BasicDiApplication.class, args);
		WishMessageGenerator generator = ctx.getBean("wmg",WishMessageGenerator.class);
		String msg = generator.generateWishMessage("Raja");
		System.out.println("generated message :: " + msg);
		((ConfigurableApplicationContext)ctx).close();
	}
	
	@Bean("ldt")
	public LocalDateTime createDateTime() {
		
		LocalDateTime ldt = LocalDateTime.now();
		return ldt;
	}

}
