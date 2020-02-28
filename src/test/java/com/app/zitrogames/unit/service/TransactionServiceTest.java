package com.app.zitrogames.unit.service;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.zitrogames.rest.dao.TransactionDao;
import com.app.zitrogames.rest.model.Transaction;
import com.app.zitrogames.rest.service.transaction.impl.TransactionServiceImpl;

@RunWith(SpringRunner.class)
@FixMethodOrder(NAME_ASCENDING)
public class TransactionServiceTest {

	@Mock
	private TransactionDao transactionDao;

	@InjectMocks
	private TransactionServiceImpl transactionService;

	@Test
	public void test001_save() {
		transactionService.saveTransaction(new Transaction());
		verify(transactionDao).save(any());
	}
}
