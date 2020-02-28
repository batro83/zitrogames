package com.app.zitrogames.rest.dto;

import javax.validation.constraints.NotNull;

public class PokerBetDto extends BaseBetDto {

	@NotNull
	private String pokerModality;

	public String getPokerModality() {
		return pokerModality;
	}

	public void setPokerModality(String pokerModality) {
		this.pokerModality = pokerModality;
	}
}
