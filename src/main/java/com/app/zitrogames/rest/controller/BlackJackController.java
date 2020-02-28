package com.app.zitrogames.rest.controller;

import static org.slf4j.LoggerFactory.getLogger;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.zitrogames.rest.config.game.BlackJackConfig;
import com.app.zitrogames.rest.dto.BaseBetDto;
import com.app.zitrogames.rest.service.game.impl.BlackJackServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/casino/blackjack")
public class BlackJackController {

	private static final Logger LOG = getLogger(ConnectController.class);

	@Autowired
	private BlackJackConfig blackJackConfig;

	@Autowired
	private BlackJackServiceImpl blackJackService;

	@ApiOperation(value = "Play blackjack", notes = "Play blackjack")
	@PostMapping("/{userId}")
	public ResponseEntity<HttpStatus> bet(@PathVariable("userId") String userId, @RequestBody @Valid BaseBetDto betDto)
			throws Exception {
		LOG.info("BlackJackController - bet: user {} bet {}", userId, betDto.toString());
		blackJackService.bet(userId, betDto, blackJackConfig);
		return ResponseEntity.ok(HttpStatus.OK);
	}

}