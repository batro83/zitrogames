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

import com.app.zitrogames.rest.config.game.SlotConfig;
import com.app.zitrogames.rest.dto.BaseBetDto;
import com.app.zitrogames.rest.service.game.impl.SlotServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/casino/slot")
public class SlotController {

	private static final Logger LOG = getLogger(ConnectController.class);

	@Autowired
	private SlotConfig slotConfig;

	@Autowired
	private SlotServiceImpl slotService;

	@ApiOperation(value = "Play slot", notes = "Play slot")
	@PostMapping("/{userId}")
	public ResponseEntity<HttpStatus> bet(@PathVariable("userId") String userId, @RequestBody @Valid BaseBetDto betDto,
			@RequestHeader("Authorization") String token) throws Exception {
		LOG.info("SlotController - bet: user {} bet {}", userId, betDto.toString());
		slotService.bet(userId, betDto, slotConfig);
		return ResponseEntity.ok(HttpStatus.OK);
	}
}