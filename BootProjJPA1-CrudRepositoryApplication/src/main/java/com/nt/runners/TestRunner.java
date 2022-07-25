package com.nt.runners;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.service.IActorService;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IActorService service;
	@Override
	public void run(String... args) throws Exception {
		/*
		try {
			Actor actor = new Actor();
			actor.setAid(41);
			actor.setActName("Mohan Babu");
			actor.setCategory("Dialog King Hero");
			actor.setMobileNo(123456789L);
			String result = service.registerActor(actor);
			System.out.println(result);
			}
			catch(DataAccessException dae)
			{
				dae.printStackTrace();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
*/
	/*	try {
			List<Actor> list = List.of(new Actor(1,"Shalini","ChildArtist",456789L),
					new Actor(2,"Tarun","Male Child Artist",456799L),
					new Actor(1,"Ram","Hero",456769L),
					new Actor(1,"Rao Gopal Rao","Villian",456784L),
					new Actor(1,"Prabhas","Hero",456781L));
			String msg = service.registerActorsGroup(list);
			System.out.println(msg);
		}
		catch(DataAccessException dae)
		{
			dae.printStackTrace();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();		
		}
*/
		try {
		
			System.out.println("Record count is : " + service.fetchActorCount());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		//Iterable interface to iterate the elements.
		try {
			System.out.println("-----------iterable for each method iteration--------------");
			Iterable<Actor> list = service.fetchAllActors();
			list.forEach(actor->System.out.println(actor));
			
			/*
			 * System.out.println("-----method reference--------");
			 * list.forEach(System.out::prinln);
			 */
			System.out.println("--------Enhanced for loop--------");
			for(Actor actor: list) {
				System.out.println(actor);
			}
			
			List<Actor> lActor = (List<Actor>) list;
			lActor.forEach(System.out::println);
			
			
			System.out.println("--------stream-count ------------");
			System.out.println("Count number of records:: " + lActor.stream().count());
			
			System.out.println("-----sorted records---------------");
			lActor.stream().sorted(Comparator.comparing(actor->actor.getAid())).forEach(System.out::println);
			
			System.out.println("-----sorted records------by name---------");
			lActor.stream().sorted((a1,a2)->a1.getActName().compareTo(a2.getActName())).forEach(System.out::println);
			
			System.out.println("-----names list--------------");
			List<String> nameList = lActor.stream().map(actor->actor.getActName()).collect(Collectors.toList());
			nameList.forEach(System.out::println);
			
			
			System.out.println("----------------get all records by ids method ------------");
			
			service.fetchActorsByIds(List.of(40,41,42)).forEach(System.out::println);
			System.out.println("-----arrays.aslist method -------");
			service.fetchActorsByIds(Arrays.asList(40,41,42)).forEach(actor->System.out.println(actor));
			
			
			System.out.println("----optional class test -------");
			Optional<Actor> opt = service.findByID(41);
			if(opt.isPresent()) {
				System.out.println("Actor found :: " + opt.get());
			}
			else {
				throw new IllegalArgumentException("Actor not found");
			}
			
			System.out.println("----orelsethrow------- method-----");
			Optional<Actor> opt1 = service.findByID(41);
			Actor act = opt1.orElseThrow(()->new IllegalArgumentException("Actor Not Found"));
			System.out.println(act);	
			
			System.out.println("----------orelse-----------");
			Optional<Actor> opt2 = service.findByID(40);
			Actor act1 = opt2.orElse(new Actor());
			System.out.println("Actor act1:: " +act1);
			
			
			System.out.println("-------------find by id returning directly ------");
			System.out.println(" actor information :: " + service.showActorById(41));
			
			System.out.println("-------------update actor mobile number ------");
			System.out.println(" actor information :: " + service.updateActorMobileNo(41, 555555555L));
			
			System.out.println("-------------update actor full update operation ------");
			System.out.println(" actor information :: " + service.updateActor(new Actor(41,"Mohan Babu","Collection King",1111111111L)));
			
			System.out.println("---save or update object operation------------");
			Actor actor = new Actor(42,"Rajendra Prasad", "Commedian",4444444444444L);
			System.out.println(service.registerOrUpdateActor(actor));
			
			Actor actor2 = new Actor(81,"Arjun", "Hero",7777744444444L);
			System.out.println(service.registerOrUpdateActor(actor2));
			
			System.out.println("---delete object operation-by id-----------");
			System.out.println(service.removeActorById(81));
			
			System.out.println("---delete object operation-by actor object-----------");
			System.out.println(service.removeActorById(new Actor(81,null,null,null)));
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
