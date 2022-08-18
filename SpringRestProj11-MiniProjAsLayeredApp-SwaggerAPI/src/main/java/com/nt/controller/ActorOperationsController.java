package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;
import com.nt.service.IActorMgmtService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/actor/api")
public class ActorOperationsController {
	
	@Autowired
	private IActorMgmtService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor){
		
		String msg = service.registerActor(actor);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/showAll")
	@ApiOperation("Gives all Actors information")
	public ResponseEntity<Iterable<Actor>> fetchAllActors(){
		Iterable<Actor> list = service.fetchAllActors();
		return new ResponseEntity<Iterable<Actor>>(list,HttpStatus.OK);
	}

	@GetMapping("/showActorById/{actorId}")
	public ResponseEntity<Actor> findActorById(@PathVariable Integer actorId){
		Actor actor = service.fetchActorById(actorId);
		return new ResponseEntity<Actor>(actor,HttpStatus.OK);
	}
	
	@GetMapping("/showAllByNames")
	public ResponseEntity<Iterable<Actor>> fetchAllActorsByName(){
		Iterable<Actor> list = service.fetchAllActorsByNameOrder();
		return new ResponseEntity<Iterable<Actor>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/showByCategory/{category1}/{category2}")
	public ResponseEntity<?> getActorsByCategory(@PathVariable String category1, @PathVariable String category2){
		List<Actor> list = service.getActorsByCategory(category1, category2);
		return new ResponseEntity<List<Actor>> (list,HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyActorInfo(@RequestBody Actor actor){
		
		String msg = service.updateActor(actor);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	//Yet to test delete functionality
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteActor(@PathVariable("id") int id){
		
		String msg = service.deleteActorById(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PatchMapping("/updatemobile/{id}/{mobileNo}")
	public ResponseEntity<String> updateMobileNo(@PathVariable int id, @PathVariable long mobileNo){
		String msg = service.updateActorMobileNo(id, mobileNo);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
