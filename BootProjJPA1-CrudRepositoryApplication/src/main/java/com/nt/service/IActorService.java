package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Actor;

public interface IActorService {
public String registerActor(Actor actor);
public String registerActorsGroup(Iterable<Actor> actorsList);
public long fetchActorCount();
public Iterable<Actor> fetchAllActors();
public Iterable<Actor> fetchActorsByIds(Iterable<Integer> ids);
public Optional<Actor> findByID(int aid);
public Actor showActorById(int id);
public String updateActorMobileNo(int aid, long newMobileNo);
public String updateActor(Actor actor);
public String registerOrUpdateActor(Actor actor);
public String removeActorById(int aid);
public String removeActorById(Actor aid);
}
