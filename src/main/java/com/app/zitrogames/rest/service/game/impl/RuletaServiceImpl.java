package com.app.zitrogames.rest.service.game.impl;

import org.springframework.stereotype.Service;

import com.app.zitrogames.rest.config.game.RuletaConfig;
import com.app.zitrogames.rest.dto.RuletaBetDto;
import com.app.zitrogames.rest.service.game.BaseGameService;

@Service
public class RuletaServiceImpl extends BaseGameService<RuletaConfig, RuletaBetDto> {

	@Override
	public void bet(String userId, RuletaBetDto betDto, RuletaConfig config) throws Exception {
		checkBalance(userId, betDto.getBet());
		checkAmountBet(betDto.getBet(), config);
		// Particular checks for this game
		checkNumberSelected(betDto.getNumber());
		generateTransaction(userId, config.getId(), betDto.getBet() * -1);
		// Play random jackpot set by jackpotOdds config game propertie
		if (Math.random() >= 1.0 - (config.getJackpotOdds() / 100)) {
			generateTransaction(userId, config.getId(), config.getPlayConfig().getJackpot());
		}
	}

	private void checkNumberSelected(int numberSelected) {}
}