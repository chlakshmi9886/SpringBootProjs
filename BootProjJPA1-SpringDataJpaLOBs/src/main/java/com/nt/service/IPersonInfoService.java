package com.nt.service;

import com.nt.entity.PersonInfo;

public interface IPersonInfoService {

	public String registerPersonInfo(PersonInfo info);
	public PersonInfo fetchPersonDetailsById(Integer pid);
}
