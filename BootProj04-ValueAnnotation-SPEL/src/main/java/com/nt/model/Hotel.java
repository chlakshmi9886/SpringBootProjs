package com.nt.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hotel")
public class Hotel {

	@Value("1234")//direct value assignment
	private Integer hotelId;
	@Value("${hotel.name}")
	private String hotelName;
	@Value("${hotel.address}")
	private String hotelAddrs;
	@Value("${hotel.contactno}")
	private String mobileNo;
	
	@Value("${customer.name}")
	private String custName;
	
	@Value("#{menuprice.idlyrate + menuprice.pohaprice}")
	private float billamt;
	
	@Value("${os.name}")
	private String osName;
	
	@Value("${user.name}")
	private String windowsUser;
	@Value("${Path}")
	private String pathData;
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelAddrs=" + hotelAddrs + ", mobileNo="
				+ mobileNo + ", custName=" + custName + ", billamt=" + billamt + ", osName=" + osName + ", windowsUser="
				+ windowsUser + ", pathData=" + pathData + "]";
	}
	
	
}
