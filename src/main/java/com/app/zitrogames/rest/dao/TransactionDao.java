package com.app.zitrogames.rest.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.zitrogames.rest.model.Transaction;

public interface TransactionDao extends PagingAndSortingRepository<Transaction, String> {

	public List<Transaction> findTransactionByUserIdOrderByDateAsc(String userId);

}
