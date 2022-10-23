package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.IBankManagementService;

@SpringBootApplication
public class DistributedTransactionMgmtTest {
	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx = SpringApplication.run(DistributedTransactionMgmtTest.class,args);//"com/nt/cfgs/applicationContext.xml");
		//get proxy class
		IBankManagementService proxy = ctx.getBean("bankService",IBankManagementService.class);
		System.out.println(proxy.getClass() + "......." + proxy.getClass().getSuperclass());
		//invoke methods
		try {
			System.out.println("Result :: " + proxy.transferMoney(1003,1009,5000.0));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
