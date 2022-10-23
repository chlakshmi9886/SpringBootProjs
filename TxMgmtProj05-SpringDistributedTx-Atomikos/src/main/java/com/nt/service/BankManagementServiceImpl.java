package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IDepositeDAO;
import com.nt.dao.IWithdrawDAO;

@Service("bankService")
public class BankManagementServiceImpl implements IBankManagementService {

	@Autowired
	private IWithdrawDAO wDAO;
	@Autowired
	private IDepositeDAO dDAO;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String transferMoney(long srcAcno, long destAcno, double amount) {
		//perform withdraw operation
		int count1 = wDAO.withdraw(srcAcno, amount);
		int count2 = dDAO.deposit(destAcno, amount);
		
		if(count1==0 || count2==0) 
			throw new RuntimeException("Tx-rolled back - Money not transfered.");
		
		return "Tx - committed - Money Transfered";
	}

}
