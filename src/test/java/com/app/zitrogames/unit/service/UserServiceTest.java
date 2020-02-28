package com.app.zitrogames.unit.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.zitrogames.rest.dao.UserDao;
import com.app.zitrogames.rest.model.User;
import com.app.zitrogames.rest.service.user.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@FixMethodOrder(NAME_ASCENDING)
public class UserServiceTest {

	@Mock
	private UserDao userDao;

	@InjectMocks
	private UserServiceImpl userService;

	@Test
	public void test001_save() {
		userService.save(new User());
		verify(userDao).save(any());
	}

	@Test(expected = Exception.class)
	public void test002_findByUserId_NoExist() throws Exception {
		when(userDao.findUserByUserId(any())).thenReturn(null);
		userService.findByUserId("userId");
	}

	@Test
	public void test003_findUserByUserId() throws Exception {
		when(userDao.findUserByUserId(any())).thenReturn(new User());
		User user = userService.findByUserId("userId");
		assertNotNull(user);
	}

}
