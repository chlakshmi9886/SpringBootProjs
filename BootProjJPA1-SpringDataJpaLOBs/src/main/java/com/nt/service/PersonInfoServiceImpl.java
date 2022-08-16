package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.PersonInfo;
import com.nt.repository.IPersonInfoRepository;

@Service("personServ")
public class PersonInfoServiceImpl implements IPersonInfoService {

	@Autowired
	private IPersonInfoRepository personRepo;
	
	@Override
	public String registerPersonInfo(PersonInfo info) {
		return "Person with the id " + personRepo.save(info).getPid() + " is saved";
	}

	@Override
	public PersonInfo fetchPersonDetailsById(Integer pid) {
		return personRepo.findById(pid).orElseThrow(()->new IllegalArgumentException("Person not found Exception"));
	}

}
