package com.nt.service;

import java.util.List;

import com.nt.model.Actor;

public interface IActorMgmtService {

	public String registerActor(Actor actor);
	public Iterable<Actor> fetchAllActors();
	public Actor fetchActorById(Integer actorId);
	public Iterable<Actor> fetchAllActorsByNameOrder();
	public List<Actor> getActorsByCategory(String category1, String category2);
	public String updateActor(Actor actor);
	public String deleteActorById(int actorId);
	public String updateActorMobileNo(int actorId, long newMobileNo);
}
