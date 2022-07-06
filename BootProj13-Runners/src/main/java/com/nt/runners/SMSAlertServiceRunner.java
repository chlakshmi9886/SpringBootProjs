package com.nt.runners;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SMSAlertServiceRunner implements ApplicationRunner {

	
	public SMSAlertServiceRunner() {
		System.out.println("SMSAlertServiceRunner.SMSAlertServiceRunner()");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("SMSAlertServiceRunner.run()");
		System.out.println("non option args ... " + args.getNonOptionArgs());
		System.out.println("option args ...keys:  " + args.getOptionNames());
		System.out.println("option args value... " + args.getOptionValues("key"));
		System.out.println("all arg values .." + Arrays.toString(args.getSourceArgs()));

	}

}
