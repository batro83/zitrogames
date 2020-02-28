package com.app.zitrogames.rest.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.zitrogames.rest.model.User;

public interface UserDao extends PagingAndSortingRepository<User, String> {

	public User findUserByUserId(String userId);

}
