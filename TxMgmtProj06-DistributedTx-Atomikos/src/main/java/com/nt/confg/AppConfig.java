package com.nt.confg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class AppConfig {

	@Bean(name="aksDtxService")
	public UserTransactionImp createAksDtxService() {
		return new UserTransactionImp();
	}
	
	@Bean(name="aksDtxMgmr")
	public UserTransactionManager createAksDtxMgmt() {
		return new UserTransactionManager();
	}
	
	@Bean(name="jtaTxMgmr")
	public JtaTransactionManager createJtaTxMgmr() {
		JtaTransactionManager jta = new JtaTransactionManager();
		jta.setUserTransaction(createAksDtxService());
		jta.setTransactionManager(createAksDtxMgmt());
		return jta;
		//return new JtaTransactionManager(createAksDtxMgmt(), createAksDtxService())
	}
}
