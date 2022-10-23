package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankManagementService;

public class DistributedTransactionMgmtTest {
	public static void main(String[] args) {
		//create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get proxy class
		IBankManagementService proxy = ctx.getBean("bankService",IBankManagementService.class);
		//invoke methods
		try {
			System.out.println("Result :: " + proxy.transferMoney(1003,1008,5000.0));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//close container
		ctx.close();
	}//main
}//class
