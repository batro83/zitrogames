package com.app.zitrogames.rest.dto;

import javax.validation.constraints.NotNull;

public class RuletaBetDto extends BaseBetDto {

	@NotNull
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
