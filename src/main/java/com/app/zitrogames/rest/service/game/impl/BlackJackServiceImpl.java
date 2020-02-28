package com.app.zitrogames.rest.service.game.impl;

import org.springframework.stereotype.Service;

import com.app.zitrogames.rest.config.game.BlackJackConfig;
import com.app.zitrogames.rest.dto.BaseBetDto;
import com.app.zitrogames.rest.service.game.BaseGameService;

@Service
public class BlackJackServiceImpl extends BaseGameService<BlackJackConfig, BaseBetDto> {

	@Override
	public void bet(String userId, BaseBetDto betDto, BlackJackConfig config) throws Exception {
		checkBalance(userId, betDto.getBet());
		checkAmountBet(betDto.getBet(), config);
		generateTransaction(userId, config.getId(), betDto.getBet() * -1);
		// Play random jackpot set by jackpotOdds config game propertie
		if (Math.random() >= 1.0 - (config.getJackpotOdds() / 100)) {
			generateTransaction(userId, config.getId(), config.getPlayConfig().getJackpot());
		}
	}
}