package com.app.zitrogames.rest.dto;

import javax.validation.constraints.NotNull;

public class PlayerConnectDto {

	@NotNull
	private String id;
	@NotNull
	private double balance;
	@NotNull
	private long playTime;
	@NotNull
	private String provider;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getPlayTime() {
		return playTime;
	}

	public void setPlayTime(long playTime) {
		this.playTime = playTime;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

}
