package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dDAO")
public class DepositDAOImpl implements IDepositeDAO {

	private static final String DEPOSIT_QUERY = "UPDATE DTX_BANK_ACCOUNT SET BALANCE=BALANCE+? WHERE ACCOUNT_NO=?";
	
	@Autowired
	@Qualifier("mysqlTemplate")
	private JdbcTemplate jt;
	
	@Override
	public int deposit(long accno, double amount) {
		int count2 = 0; 
		try {
			System.out.println(jt.getDataSource());
		 count2 = jt.update(DEPOSIT_QUERY,amount,accno);
		System.out.println("count 2:: " + count2);
	}catch(Exception ex) {
		System.out.println(ex.getMessage());
	}
		return count2;
	}

}
