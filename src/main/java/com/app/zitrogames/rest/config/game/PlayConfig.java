package com.app.zitrogames.rest.config.game;

import javax.validation.constraints.NotNull;

public class PlayConfig {

	@NotNull
	private double maxBet;
	@NotNull
	private double minBet;
	@NotNull
	private double jackpot;

	public double getMaxBet() {
		return maxBet;
	}

	public void setMaxBet(double maxBet) {
		this.maxBet = maxBet;
	}

	public double getMinBet() {
		return minBet;
	}

	public void setMinBet(double minBet) {
		this.minBet = minBet;
	}

	public double getJackpot() {
		return jackpot;
	}

	public void setJackpot(double jackpot) {
		this.jackpot = jackpot;
	}

}
