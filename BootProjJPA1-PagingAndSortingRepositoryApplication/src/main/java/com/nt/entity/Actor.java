package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="DATA_JPA_ACTOR")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ACTOR_ID")
	private Integer aid;
	@NonNull
	@Column(name="ACTOR_NAME", length =20)
	private String aname;
	@Column(name="CATEGORY", length = 20)
	@NonNull
	private String category;
	@Column(name="MOBILE_NO")
	@NonNull
	private Long MobileNo;
}
