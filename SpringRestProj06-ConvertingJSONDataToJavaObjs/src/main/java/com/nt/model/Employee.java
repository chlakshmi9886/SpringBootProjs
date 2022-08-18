package com.nt.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class Employee {

	private Integer empNo;
	private String empName;
	private Address address;
	private String[] favColors;
	private List<String> nickNames;
	private Set<Long> phoneNumbers;
	private Map<String, Long> idDetails;
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String[] getFavColors() {
		return favColors;
	}
	public void setFavColors(String[] favColors) {
		this.favColors = favColors;
	}
	public List<String> getNickNames() {
		return nickNames;
	}
	public void setNickNames(List<String> nickNames) {
		this.nickNames = nickNames;
	}
	public Set<Long> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Map<String, Long> getIdDetails() {
		return idDetails;
	}
	public void setIdDetails(Map<String, Long> idDetails) {
		this.idDetails = idDetails;
	}
	public Employee(Integer empNo, String empName, Address address, String[] favColors, List<String> nickNames,
			Set<Long> phoneNumbers, Map<String, Long> idDetails) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.address = address;
		this.favColors = favColors;
		this.nickNames = nickNames;
		this.phoneNumbers = phoneNumbers;
		this.idDetails = idDetails;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", address=" + address + ", favColors="
				+ Arrays.toString(favColors) + ", nickNames=" + nickNames + ", phoneNumbers=" + phoneNumbers
				+ ", idDetails=" + idDetails + "]";
	}
	
}
