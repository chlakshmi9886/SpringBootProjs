package com.nt.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("hotel")
@ConfigurationProperties(prefix="hotel")
@Data
public class Hotel {	
	private Integer hotelId;
	private String name;
	private String address;
	private String contactno;
	private String custName;	
	
	@Autowired
	private MenuPrices prices;
}
