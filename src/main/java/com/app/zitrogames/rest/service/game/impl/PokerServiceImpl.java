package com.app.zitrogames.rest.service.game.impl;

import org.springframework.stereotype.Service;

import com.app.zitrogames.rest.config.game.PokerConfig;
import com.app.zitrogames.rest.dto.PokerBetDto;
import com.app.zitrogames.rest.service.game.BaseGameService;

@Service
public class PokerServiceImpl extends BaseGameService<PokerConfig, PokerBetDto> {

	@Override
	public void bet(String userId, PokerBetDto betDto, PokerConfig config) throws Exception {
		checkBalance(userId, betDto.getBet());
		checkAmountBet(betDto.getBet(), config);
		// Particular checks for this game
		checkPokerModality(betDto.getPokerModality());
		generateTransaction(userId, config.getId(), betDto.getBet() * -1);
		// Play random jackpot set by jackpotOdds config game propertie
		if (Math.random() >= 1.0 - (config.getJackpotOdds() / 100)) {
			generateTransaction(userId, config.getId(), config.getPlayConfig().getJackpot());
		}
	}

	private void checkPokerModality(String pokerModality) {}
}