package com.nt.rest;

import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/ticket")
public class TicketBookingController {

	@GetMapping("/booking")
	@HystrixCommand(fallbackMethod = "dummyBookTicket")
	public String bookTicket(){
		
		System.out.println("TicketBookingController.bookTicket()");
		if(new Random().nextInt(10) <8){
			throw new RuntimeException("Problem in b.logic");
		}
		return "Ticket booked successfully....";
	}
	public String dummyBookTicket() {
		System.out.println("TicketBookingController.dummyBookTicket()");
		return "Please try later ..............";
	}
}
