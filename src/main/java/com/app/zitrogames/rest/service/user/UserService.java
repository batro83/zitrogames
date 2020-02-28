package com.app.zitrogames.rest.service.user;

import com.app.zitrogames.rest.model.User;

public interface UserService {

	public void save(User user);

	public User findByUserId(String userId) throws Exception;
}
