package com.app.zitrogames.rest.service.transaction.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.zitrogames.rest.dao.TransactionDao;
import com.app.zitrogames.rest.model.Transaction;
import com.app.zitrogames.rest.service.transaction.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Override
	public Transaction saveTransaction(Transaction transaction) {
		return transactionDao.save(transaction);
	}

}
