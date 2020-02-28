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

import com.app.zitrogames.rest.config.game.VideoBingoConfig;
import com.app.zitrogames.rest.dto.BaseBetDto;
import com.app.zitrogames.rest.service.game.impl.VideoBingoServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/casino/casino")
public class VideoBingoController {

	private static final Logger LOG = getLogger(ConnectController.class);

	@Autowired
	private VideoBingoConfig videobingoConfig;

	@Autowired
	private VideoBingoServiceImpl videoBingoService;

	@ApiOperation(value = "Play videobingo", notes = "Play videobingo")
	@PostMapping("/{userId}")
	public ResponseEntity<HttpStatus> videobingo(@PathVariable("userId") String userId,
			@RequestBody @Valid BaseBetDto betDto, @RequestHeader("Authorization") String token) throws Exception {
		LOG.info("VideoBingoController - bet: user {} amount {}", userId, betDto.toString());

		videoBingoService.bet(userId, betDto, videobingoConfig);
		return ResponseEntity.ok(HttpStatus.OK);
	}

}