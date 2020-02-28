package com.app.zitrogames.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.zitrogames.rest.model.User;
import com.app.zitrogames.rest.service.balance.impl.BalanceServiceImpl;
import com.app.zitrogames.rest.service.user.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@FixMethodOrder(NAME_ASCENDING)
public class BalanceServiceTest {

	@Mock
	private UserServiceImpl userService;

	@InjectMocks
	private BalanceServiceImpl balanceService;

	@Test
	public void test001_getUserBalance() throws Exception {
		User userMock = new User();
		userMock.setId("id");
		userMock.setCashier(100d);
		when(userService.findByUserId("id")).thenReturn(userMock);

		double balance = balanceService.getUserBalance("id");
		assertEquals(userMock.getCashier(), balance, 0);
	}

	@Test
	public void test002_getUserBalance() throws Exception {
		when(userService.findByUserId("id")).thenReturn(null);
		double balance = balanceService.getUserBalance("id");
		assertEquals(0d, balance, 0);
	}

	@Test
	public void test002_updateBalance_bet() throws Exception {
		User userMock = new User();
		userMock.setId("id");
		userMock.setCashier(100d);
		when(userService.findByUserId("id")).thenReturn(userMock);

		balanceService.updateUserBalance("id", -20);

		verify(userService).save(any());
	}

}
