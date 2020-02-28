package com.app.zitrogames.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.OK;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.zitrogames.rest.dao.UserDao;
import com.app.zitrogames.rest.dto.PlayerConnectDto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(NAME_ASCENDING)
@ActiveProfiles("test")
public class ConnectControllerIntregrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private UserDao userDao;

	@Test
	public void test000_cleanDb() throws Exception {
		userDao.deleteAll();
	}

	@Test
	public void test001_connectPlayer() throws Exception {
		final String path = "/connect";
		PlayerConnectDto dto = new PlayerConnectDto();
		dto.setBalance(1000);
		dto.setId("idUser");
		dto.setPlayTime(50_000);
		dto.setProvider("PokerStars");
		HttpEntity<PlayerConnectDto> request = new HttpEntity<>(dto);
		final ResponseEntity<String> response = restTemplate.exchange(path, POST, request, String.class);
		assertEquals(OK, response.getStatusCode());
		assertNotNull(response.getBody());
	}

}
