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

	@Override
	public Actor showActorById(int id) {
		/*Optional<Actor> opt = actorRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
		throw new IllegalArgumentException("Actor not Found");
		}
		*/
		//Optional<Actor> opt1= actorRepo.findById(id);
		//return opt1.orElseThrow(()->new IllegalArgumentException("Actor Not Found"));
		
		return actorRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Actor Not Found"));
		
	}

	@Override
	public String updateActorMobileNo(int aid, long newMobileNo) {
		Optional<Actor> opt = actorRepo.findById(aid);
		if(opt.isPresent()) {
			Actor actor = opt.get();
			actor.setMobileNo(newMobileNo);
			actorRepo.save(actor);
			return aid + " actor is updated with new mobile no : " +newMobileNo;
		}
		return aid+ " Actor not found for update operation";
	}

	@Override
	public String updateActor(Actor actor) {
		boolean flag = actorRepo.existsById(actor.getAid());
		if(flag) {
			actorRepo.save(actor);
			return actor.getAid()+" actor information is updated";
		}
		else
		{
			return actor.getAid()+" actor information not found for updation";
		}
	}

	@Override
	public String registerOrUpdateActor(Actor actor) {
		Actor mactor = actorRepo.save(actor);
		return mactor.getAid()+" actor is saved or updated successfully.";
	}

	@Override
	public String removeActorById(int aid) {
		Optional<Actor> opt = actorRepo.findById(aid);
		if(opt.isPresent())
		{
			actorRepo.deleteById(aid);
			return aid+" actor is deleted ";
		}else {
			return aid +" actor is not found for deletion";
		}
		
	}

	@Override
	public String removeActorById(Actor aid) {
		boolean flag = actorRepo.existsById(aid.getAid());
		if(flag)
		{
			actorRepo.deleteById(aid.getAid());
			return aid.getAid() +" actor deleted";
		}
		return aid.getAid() +" actor not found for deletion";
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
