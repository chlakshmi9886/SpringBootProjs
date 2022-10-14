package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//@RequestMapping("/ShoppingMs")
public class ShoppingServiceOperationsController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/shopping")
	public String doShopping() {
		
		//invoke the method another micro service 
		String msg = template.getForObject("http://localhost:9192/billing", String.class);
		return "Shopping Operations : " +msg;
	}
}
