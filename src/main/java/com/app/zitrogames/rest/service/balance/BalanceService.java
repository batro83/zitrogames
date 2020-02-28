package com.app.zitrogames.rest.service.balance;

public interface BalanceService {

	public double getUserBalance(String user) throws Exception;

	public void updateUserBalance(String user, double profit) throws Exception;
}
