package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//@RequestMapping("/BillingMs")
public class BillingOperationsController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/billing")
	public String doBilling() {
		// invoke the method another micro service (paymentoperationscontroller - MS)
		String msg = template.getForObject("http://localhost:9193/payment", String.class);
		return "Bill Amount :9000 :" +msg;
	}
}
