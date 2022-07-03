package com.nt.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {

	@Autowired
	private LocalDateTime ldt;
	
	public String generateWishMessage(String user) {
		String msg;
		int hour = ldt.getHour();
		if(hour <12) {
			msg = "GM "  + user;
		}
		else if(hour<16) {
			msg = "GA "+ user;
		}
		else if(hour<20) {
			msg = "GE "+ user;
		}
		else {
			msg = "GN "+ user;
		}
		return msg;
	}
	
	
}
