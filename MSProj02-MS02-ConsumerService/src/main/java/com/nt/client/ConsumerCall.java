package com.nt.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer/api")
public class ConsumerCall {

	@Autowired
	private BillingServiceConsumerClient consumerClient;
	
	@GetMapping("/info")
	public String getBillInfo(){
		return "Bill Info :: " + consumerClient.getBillingInfo();
	}
}
