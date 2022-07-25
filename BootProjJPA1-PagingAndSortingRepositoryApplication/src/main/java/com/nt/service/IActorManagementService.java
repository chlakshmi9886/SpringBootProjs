package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.nt.entity.Actor;

public interface IActorManagementService {

	public Iterable<Actor> showAllActorsBySortingOrder(boolean asc, String...args);
	public Page<Actor> showPageRecords(int pageNo, int pageSize);
	public Page<Actor> showPageRecordsSortOrder(int pageNo, int pageSize, Sort obj);
	public void showActorsByPage(int pageSize);
}
