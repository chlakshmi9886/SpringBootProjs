package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Service
public class IActorManagementServiceImpl implements IActorManagementService {

	@Autowired
	private IActorRepository actorRepo;
	
	@Override
	public Iterable<Actor> showAllActorsBySortingOrder(boolean asc, String... args) {
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC,args);
		Iterable<Actor> it = actorRepo.findAll(sort);
		return it;
	}
@Override
public Page<Actor> showPageRecords(int pageNo, int pageSize) {
	Pageable pageable = PageRequest.of(pageNo, pageSize);
	Page<Actor> page = actorRepo.findAll(pageable);	
	return page;
}
@Override
public Page<Actor> showPageRecordsSortOrder(int pageNo, int pageSize, Sort obj) {
	//Sort sort = Sort.by(Direction.ASC,"aname");
	Pageable pageable = PageRequest.of(pageNo, pageSize, obj);
	Page<Actor> it = actorRepo.findAll(pageable);
	return it;
}
@Override
public void showActorsByPage(int pageSize) {
	long recordsCount = actorRepo.count();
	long pagesCount = recordsCount/pageSize;
	pagesCount = (recordsCount%pageSize==0)?pagesCount:++pagesCount;
	
	for(int i=0;i<pagesCount;++i) {
		Pageable pageable = PageRequest.of(i, pageSize);
		Page<Actor> page = actorRepo.findAll(pageable);
		System.out.println((i+1)+" page records.....");
		page.getContent().forEach(System.out::println);
	}
}
}
