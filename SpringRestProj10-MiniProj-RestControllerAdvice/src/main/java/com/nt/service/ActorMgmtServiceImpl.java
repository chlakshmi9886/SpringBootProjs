package com.nt.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.exception.ActorNotFoundException;
import com.nt.model.Actor;
import com.nt.repository.IActroRepo;

@Service("actorMgmtService")
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IActroRepo repo;
	
	@Override
	public String registerActor(Actor actor) {
		Actor loActor = repo.save(actor);
		return "Actor is registered with the ID : " +loActor.getActorId();
	}

	@Override
	public Iterable<Actor> fetchAllActors() {
		Iterable<Actor> list = repo.findAll();
		List<Actor> list1 = (List<Actor>) list;
		return list1;
	}

	@Override
	public Actor fetchActorById(Integer actorId) {
		return repo.findById(actorId).orElseThrow(()->new IllegalArgumentException());
	}

	/*
	 * @Override public Iterable<Actor> fetchAllActorsByNameOrder() {
	 * Iterable<Actor> list = repo.findAll(); List<Actor> list1 = (List<Actor>)
	 * list;
	 * list1.sort((t1,t2)->t1.getActorName().compareToIgnoreCase(t2.getActorName()))
	 * ; return list1; }
	 */
	
	/*
	 * @Override public Iterable<Actor> fetchAllActorsByNameOrder() {
	 * Iterable<Actor> it = repo.findAll(); Collections.sort((List<Actor>) it,
	 * (t1,t2)->t1.getActorName().compareToIgnoreCase(t2.getActorName())); return
	 * it; }
	 */
	
	@Override
	public Iterable<Actor> fetchAllActorsByNameOrder() {
		Iterable<Actor> it = repo.findAll();
		List<Actor> list = StreamSupport.stream(it.spliterator(), 
				false).sorted((t1,t2)->t1.getActorName().compareToIgnoreCase(
						t2.getActorName())).collect(Collectors.toList());

		return list;
	}

	@Override
	public List<Actor> getActorsByCategory(String category1, String category2) {
		
		List<Actor> list = repo.getActorsByCategory(category1, category2);
		Collections.sort(list, (t1,t2)->t1.getActorName().compareToIgnoreCase(t2.getActorName()));
		return list;
	}

	@Override
	public String updateActor(Actor actor) {

		Optional<Actor> opt = repo.findById(actor.getActorId());
		if(opt.isPresent()) {
			repo.save(actor);
			return "Actor Information Updated...";
		}
		else {
			throw new ActorNotFoundException("Actor not Found");
		}		
	}

	@Override
	public String deleteActorById(int actorId) {
		Optional<Actor> opt = repo.findById(actorId);
		if(opt.isPresent()) {
			repo.deleteById(actorId);
			return "Actor Information is deleted...";
		}
		else {
			throw new ActorNotFoundException("Actor not Found");
		}		
	}

	@Override
	public String updateActorMobileNo(int actorId, long newMobileNo) {
		Optional<Actor> opt =  repo.findById(actorId);
		if(opt.isPresent())
		{
			Actor actor = opt.get();
			actor.setMobileNo(newMobileNo);
			repo.save(actor);
			return "Actor Mobile Number is updated";
		}
		else {
			throw new ActorNotFoundException("Actor not Found");
		}
		
	}

}
