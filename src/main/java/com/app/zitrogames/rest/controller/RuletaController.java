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

import com.app.zitrogames.rest.config.game.RuletaConfig;
import com.app.zitrogames.rest.dto.RuletaBetDto;
import com.app.zitrogames.rest.service.game.impl.RuletaServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/casino/ruleta")
public class RuletaController {

	private static final Logger LOG = getLogger(ConnectController.class);

	@Autowired
	private RuletaConfig ruletaConfig;

	@Autowired
	private RuletaServiceImpl ruletaService;

	@ApiOperation(value = "Play ruleta", notes = "Play ruleta")
	@PostMapping("/{userId}")
	public ResponseEntity<HttpStatus> bet(@PathVariable("userId") String userId,
			@RequestBody @Valid RuletaBetDto betDto, @RequestHeader("Authorization") String token) throws Exception {
		LOG.info("RuletaController - bet: user {} amount {}", userId, betDto.toString());

		ruletaService.bet(userId, betDto, ruletaConfig);
		return ResponseEntity.ok(HttpStatus.OK);
	}

}