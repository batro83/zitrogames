package com.app.zitrogames.rest.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private String id;
	@NotNull
	private String userId;
	@NotNull
	@Min(0)
	private double cashier;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getCashier() {
		return cashier;
	}

	public void setCashier(double cashier) {
		this.cashier = cashier;
	}

}
