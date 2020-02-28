package com.app.zitrogames.rest.service.game;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.zitrogames.rest.config.game.BaseGameConfig;
import com.app.zitrogames.rest.dto.BaseBetDto;
import com.app.zitrogames.rest.model.Transaction;
import com.app.zitrogames.rest.service.balance.BalanceService;
import com.app.zitrogames.rest.service.game.impl.VideoBingoServiceImpl;
import com.app.zitrogames.rest.service.transaction.TransactionService;

public abstract class BaseGameService<T extends BaseGameConfig, S extends BaseBetDto> {

	public static final Logger LOG = getLogger(VideoBingoServiceImpl.class);

	@Autowired
	private BalanceService balanceService;
	@Autowired
	private TransactionService transactionService;

	public abstract void bet(String userId, S betDto, T config) throws Exception;

	protected void generateTransaction(String userId, String gameId, double amount) throws Exception {
		Transaction transaction = new Transaction();
		transaction.setDate(new Date());
		transaction.setGameId(gameId);
		transaction.setAmount(amount);
		transaction.setUserId(userId);
		Transaction saved = transactionService.saveTransaction(transaction);
		LOG.info(saved.toString());
		balanceService.updateUserBalance(userId, amount);
	}

	protected void checkBalance(String userId, double bet) throws Exception {
		double actualBalance = balanceService.getUserBalance(userId);
		if (bet > actualBalance) {
			LOG.info("User {} have not enought founds.", userId);
			throw new Exception("not enought founds");
		}
	}

	protected void checkAmountBet(double bet, T config) throws Exception {
		if (bet > config.getPlayConfig().getMaxBet() || bet < config.getPlayConfig().getMinBet()) {
			throw new Exception("bet higher or smaller than the config game");
		}
	}
}