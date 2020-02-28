package com.app.zitrogames.rest.controller;

import static org.slf4j.LoggerFactory.getLogger;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.zitrogames.rest.dto.PlayerConnectDto;
import com.app.zitrogames.rest.model.User;
import com.app.zitrogames.rest.service.user.UserService;
import com.app.zitrogames.rest.utils.JwtUtils;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/connect")
public class ConnectController {

	private static final Logger LOG = getLogger(ConnectController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtils jwtUtils;

	@ApiOperation(value = "Connect player with platform", notes = "Connect player with casino")
	@PostMapping
	public ResponseEntity<String> connect(@RequestBody @Valid PlayerConnectDto dto) {
		LOG.debug("ConnectController - connect: {}", dto.toString());
		User user = new User();
		user.setUserId(dto.getId());
		user.setCashier(dto.getBalance());
		userService.save(user);
		return ResponseEntity.ok(jwtUtils.createJWT(dto.getId(), dto.getProvider(), dto.getPlayTime()));
	}

}
