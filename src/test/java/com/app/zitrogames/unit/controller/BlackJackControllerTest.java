package com.app.zitrogames.unit.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpStatus.OK;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.zitrogames.rest.config.game.BlackJackConfig;
import com.app.zitrogames.rest.controller.BlackJackController;
import com.app.zitrogames.rest.dto.BaseBetDto;
import com.app.zitrogames.rest.service.game.impl.BlackJackServiceImpl;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BlackJackControllerTest {

	@InjectMocks
	private BlackJackController blackJackController;

	@Mock
	private BlackJackConfig blackJackConfig;

	@Mock
	private BlackJackServiceImpl blackJackService;

	@Test
	public void test001_controller() throws Exception {
		ResponseEntity<HttpStatus> response = blackJackController.bet("userId", new BaseBetDto());
		assertEquals(OK, response.getBody());
		assertEquals(OK, response.getStatusCode());
	}

	// TODO: testing all controllers
	// TODO: MVC unit test

}
