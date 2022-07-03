package com.nt.sbeans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("eEngine")
@Primary
public class ElectricEngine implements IEngine {

	public ElectricEngine() {
		System.out.println("ElectricEngine.ElectricEngine()");
	}
	@Override
	public void start() {
		System.out.println("ElectricEngine.start()");

	}

	@Override
	public void stop() {
		System.out.println("ElectricEngine.stop()");

	}

}
