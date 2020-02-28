package com.app.zitrogames.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.zitrogames.rest.dao.TransactionDao;
import com.app.zitrogames.rest.dao.UserDao;
import com.app.zitrogames.rest.dto.BaseBetDto;
import com.app.zitrogames.rest.dto.PlayerConnectDto;
import com.app.zitrogames.rest.model.Transaction;
import com.app.zitrogames.rest.model.User;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(NAME_ASCENDING)
@ActiveProfiles("test")
public class BlackJackControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private UserDao userDao;

	@Test
	public void test000_cleanDb() throws Exception {
		transactionDao.deleteAll();
		userDao.deleteAll();
	}

	@Test
	public void test001_betBlackJack() throws Exception {
		final String path = "/casino/blackjack/{userId}";
		final String userId = "idUser";
		// Connect
		String token = connectPlayer(1000d, userId, 50_000, "Pokerstars");

		// Play
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token);

		BaseBetDto dto = new BaseBetDto();
		dto.setBet(10d);

		HttpEntity<BaseBetDto> request = new HttpEntity<>(dto, headers);
		final ResponseEntity<String> response = restTemplate.exchange(path, POST, request, String.class, userId);
		assertEquals(OK, response.getStatusCode());

		// check transaction collection
		List<Transaction> transaction = transactionDao.findTransactionByUserIdOrderByDateAsc(userId);
		assertEquals(2, transaction.size());
		assertEquals(-10, transaction.get(0).getAmount(), 0);
		assertEquals(1000, transaction.get(1).getAmount(), 0);

		// check cashier player
		User user = userDao.findUserByUserId(userId);
		assertEquals(1990d, user.getCashier(), 0);

	}

	private String connectPlayer(double balance, String idUser, long playTime, String provider) {
		final String path = "/connect";
		PlayerConnectDto dto = new PlayerConnectDto();
		dto.setBalance(balance);
		dto.setId(idUser);
		dto.setPlayTime(playTime);
		dto.setProvider(provider);
		HttpEntity<PlayerConnectDto> request = new HttpEntity<>(dto);
		final ResponseEntity<String> response = restTemplate.exchange(path, POST, request, String.class);
		return response.getBody();
	}

}
