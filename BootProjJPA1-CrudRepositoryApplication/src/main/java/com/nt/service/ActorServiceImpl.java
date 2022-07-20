package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Service("ActorService")
public class ActorServiceImpl implements IActorService {

	@Autowired
	private IActorRepository actorRepo;
	
	@Override
	public String registerActor(Actor actor) {
		Actor sactor=actorRepo.save(actor);
		return "Actro is registered with Actor ID : " + sactor.getAid();
	}

	@Override
	public String registerActorsGroup(Iterable<Actor> actorsList) {
		if(actorsList != null) {
				List<Actor> list  = (List<Actor>)actorRepo.saveAll(actorsList);
				List<Integer> ids = list.stream().map(actor->actor.getAid()).collect(Collectors.toList());
				return ids.size() + " objects are saved having ids :; " + ids;
		}
		return "problem in batch insertion";
	}

	@Override
	public long fetchActorCount() {
		long count = actorRepo.count();
		return count;
	}

	@Override
	public Iterable<Actor> fetchAllActors() {
		
		return actorRepo.findAll();
	}

	@Override
	public Iterable<Actor> fetchActorsByIds(Iterable<Integer> ids) {
		
		return actorRepo.findAllById(ids);
	}

	@Override
	public Optional<Actor> findByID(int aid) {
		Optional<Actor> opt =  actorRepo.findById(aid);
		return opt;
	}

	/*
	@Override
	public String registerActorsGroup(List<Actor> actorsList) {
		if(actorsList != null) {
			Iterable<Actor> list = actorRepo.saveAll(actorsList);
			List<Integer> ids = new ArrayList<>();
			for(Actor actor:list) {
				ids.add(actor.getAid());
			}
			return ids.size() + " objects are saved having ids :; " + ids;
		}
		return "problem in batch insertion";
	}*/	

}
