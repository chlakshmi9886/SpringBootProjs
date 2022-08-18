package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.Data;

@Data
@Entity
@Table(name="EMPLOYEE_INFO_TAB")
public class EmployeeInfo {

	@Id
	@GeneratedValue
	private Integer eno;
	@Column(length=20)
	private String ename;
	@ElementCollection // enables the element collection
	@CollectionTable(name="EMPLOYEE_FRIENDS",
					joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "ENO"))// to specify the child table name and fk key column
	@Column(name="FRIEND_NAME", length = 20)//to store list elements
	@OrderColumn(name="FRIEND_INDEX")//to store list element index
	@ListIndexBase(1)
	private List<String> friends;
	@ElementCollection
	@CollectionTable(name="EMPLOYEE_MOBILE",
					joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "ENO"))
	@Column(name="PHONE_NUMBER")
	private Set<Long> phone;
	@ElementCollection
	@CollectionTable(name="EMPLOYEE_IDDETAILS",
					joinColumns = @JoinColumn(name="EMP_ID", referencedColumnName = "ENO"))
	@Column(name="ID_DETAILS")
	@MapKeyColumn(name="ID_TYPE", length = 20)
	private Map<String,String> idDetails;
}
