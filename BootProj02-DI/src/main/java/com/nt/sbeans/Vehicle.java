package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {
	
	@Autowired
	//@Qualifier("eEngine")
	//@Qualifier("pEngine")
	@Qualifier("engg")
	private IEngine engine;
	
	public Vehicle() {
		System.out.println("Vehicle.Vehicle()");
	}
	
	public void journey (String startJourney, String destPlace) {
		engine.start();
		System.out.println("Journey started at " + startJourney);
		System.out.println("journey is going on ...........");
		engine.stop();
		System.out.println("Journey reached destination " +destPlace);
	}

}
