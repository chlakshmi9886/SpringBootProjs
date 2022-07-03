package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("pEngine")
public class PatrolEngine implements IEngine {

	
	public PatrolEngine() {
		System.out.println("PATROL ENGINE CONSTRUCTOR");
	}

	@Override
	public void start() {
		System.out.println("PatrolEngine.start()");

	}

	@Override
	public void stop() {
		System.out.println("PatrolEngine.stop()");

	}

}
