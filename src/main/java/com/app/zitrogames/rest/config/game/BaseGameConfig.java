package com.app.zitrogames.rest.config.game;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class BaseGameConfig {

	@NotNull
	private String id;
	@NotNull
	private String gameType;
	@NotNull
	private int jackpotOdds;
	@NotNull
	@Valid
	private PlayConfig playConfig;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public int getJackpotOdds() {
		return jackpotOdds;
	}

	public void setJackpotOdds(int jackpotOdds) {
		this.jackpotOdds = jackpotOdds;
	}

	public PlayConfig getPlayConfig() {
		return playConfig;
	}

	public void setPlayConfig(PlayConfig playConfig) {
		this.playConfig = playConfig;
	}
}