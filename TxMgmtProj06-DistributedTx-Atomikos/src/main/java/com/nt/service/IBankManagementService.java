package com.nt.service;

public interface IBankManagementService {

	public String transferMoney(long srcAcno, long destAcno, double amount);
}
