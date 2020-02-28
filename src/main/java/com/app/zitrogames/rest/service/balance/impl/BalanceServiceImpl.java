package com.app.zitrogames.rest.service.balance.impl;

import static java.util.Optional.ofNullable;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.zitrogames.rest.model.User;
import com.app.zitrogames.rest.service.balance.BalanceService;
import com.app.zitrogames.rest.service.user.UserService;

@Service
public class BalanceServiceImpl implements BalanceService {

	@Autowired
	private UserService userService;

	@Override
	public double getUserBalance(String userId) throws Exception {
		return ofNullable(userService.findByUserId(userId)).map(u -> u.getCashier()).orElse(0.0);
	}

	@Override
	public void updateUserBalance(String userId, double amount) throws Exception {
		User user = userService.findByUserId(userId);
		user.setCashier(calculateBalance(user.getCashier(), amount));
		userService.save(user);
	}

	private double calculateBalance(double cashier, double amount) {
		BigDecimal a = new BigDecimal(cashier);
		BigDecimal b = new BigDecimal(amount);
		return a.add(b).doubleValue();
	}
}