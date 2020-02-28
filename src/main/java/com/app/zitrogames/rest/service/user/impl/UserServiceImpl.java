package com.app.zitrogames.rest.service.user.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.zitrogames.rest.dao.UserDao;
import com.app.zitrogames.rest.model.User;
import com.app.zitrogames.rest.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public User findByUserId(String userId) throws Exception {
		return Optional.ofNullable(userDao.findUserByUserId(userId))
				.orElseThrow(() -> new Exception("User doesn't exist"));
	}

}