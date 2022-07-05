package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@Data
@ConfigurationProperties(prefix="org.nit")
public class Employee {

	private Integer empNo;
	private String empName;
	private String[] favColors;
	private List<String> nickNames;
	private Set<String> phoneNumbers;
	private Map<String, Object> idDetails;
	private Company company;
}
