package com.nt.rest;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/ticket")
public class TicketBookingController {

	@GetMapping("/booking")
	@HystrixCommand(fallbackMethod = "fallBackMethod",
					commandProperties= {
							@HystrixProperty(name="circuitBreaker.enabled", value = "true"),
							@HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="5"),
							@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="10000")
							})
	public String bookTikcet() {
		System.out.println("TicketBookingController.bookTikcet()");
		if(new Random().nextInt(10) <5)
		{
			throw new RuntimeException("Problem in b.logic......");
		}
		return "ticket booked successfully....";
	}
	
	int count=0;
	public String fallBackMethod() {
		System.out.println("TicketBookingController.fallBackMethod()" + count++);
		return "Please try later";
	}
}
