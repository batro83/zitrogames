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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.zitrogames.rest.config.game.PokerConfig;
import com.app.zitrogames.rest.dto.PokerBetDto;
import com.app.zitrogames.rest.service.game.impl.PokerServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/casino/poker")
public class PokerController {

	private static final Logger LOG = getLogger(ConnectController.class);

	@Autowired
	private PokerConfig pokerConfig;

	@Autowired
	private PokerServiceImpl pokerService;

	@ApiOperation(value = "Play poker", notes = "Play poker")
	@PostMapping("/{userId}")
	public ResponseEntity<HttpStatus> poker(@PathVariable("userId") String userId,
			@RequestBody @Valid PokerBetDto betDto, @RequestHeader("Authorization") String token) throws Exception {
		LOG.info("PokerController - bet: user {} amount {}", userId, betDto.toString());

		pokerService.bet(userId, betDto, pokerConfig);
		return ResponseEntity.ok(HttpStatus.OK);
	}
}