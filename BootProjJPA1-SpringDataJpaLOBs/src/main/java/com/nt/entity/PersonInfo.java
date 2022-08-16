package com.nt.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="person_info_lob")
@Data
public class PersonInfo {

	@Id
	@GeneratedValue
	private Integer pid;
	@Column(length=20)
	private String pname;
	private LocalDateTime dob;
	private boolean married;
	@Lob
	private byte[] pimage;
	@Lob
	private char[] pbiodata;
	
}
