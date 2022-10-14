package com.nt.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/PaymentMs")
public class PaymentOperationsController {

	@GetMapping("/payment")
	public String doPayment() {
		return "payment done successfully using phone pay app";
	}
}
