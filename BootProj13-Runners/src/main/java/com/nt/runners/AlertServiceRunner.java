package com.nt.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AlertServiceRunner implements CommandLineRunner {

	public AlertServiceRunner() {
		System.out.println("AlertServiceRunner.AlertServiceRunner()");
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("AlertServiceRunner.run()");
		System.out.println("command line arguements are");
		for(String arg: args)
		{
			System.out.println(arg);
		}
	}

}
