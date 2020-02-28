package com.app.zitrogames.rest.dto;

import javax.validation.constraints.NotNull;

public class BaseBetDto {

	@NotNull
	private double bet;

	public double getBet() {
		return bet;
	}

	public void setBet(double bet) {
		this.bet = bet;
	}
}