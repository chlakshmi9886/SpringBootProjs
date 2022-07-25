package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.service.IActorManagementService;

@Component
public class ActorTestRunner implements CommandLineRunner {

	@Autowired
	private IActorManagementService service;
	
	@Override
	public void run(String... args) throws Exception {
		service.showAllActorsBySortingOrder(false, "aid").forEach(System.out::println);

		System.out.println("--------sorting using actor name -----------");
		service.showAllActorsBySortingOrder(true, "aname").forEach(System.out::println);
		System.out.println("--------sorting using actor name and actor id-----------");
		service.showAllActorsBySortingOrder(false, "aname","aid").forEach(System.out::println);
		
		Page<Actor> page = service.showPageRecords(0, 5);
		List<Actor> listActor = page.getContent();
		System.out.println("Records are --");
		listActor.forEach(System.out::println);
		System.out.println("Other information about page");
		System.out.println("current page number :: " + page.getNumber());
		System.out.println("total pages :: " + page.getTotalPages());
		System.out.println("total records" + page.getTotalElements());
		System.out.println("total elements :: " + page.getNumberOfElements());
		System.out.println(page.getSize());
		
		System.out.println("-------------pagenation using sorting ---------- ");
		Page<Actor> page1 = service.showPageRecordsSortOrder(0, 5, Sort.by(Direction.DESC,"aname"));
		List<Actor> listActor1 = page1.getContent();
		System.out.println("Records are --");
		listActor1.forEach(System.out::println);
		
		System.out.println("findall------------");
		service.showActorsByPage(3);
	}

}
