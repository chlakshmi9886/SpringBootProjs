package com.nt.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("cust")
@Data
@ConfigurationProperties(prefix="com.nt")
public class Customer {

	private Integer custNo;
	private String custName;
	private String custAddr;
	private Double billAmt;
}
