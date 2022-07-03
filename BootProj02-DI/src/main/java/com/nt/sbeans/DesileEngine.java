package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngine")
public class DesileEngine implements IEngine {

	public DesileEngine() {
		System.out.println("DesileEngine.DesileEngine()");
	}
	@Override
	public void start() {
		System.out.println("DesileEngine.start()");
	}

	@Override
	public void stop() {
		System.out.println("DesileEngine.stop()");

	}

}
