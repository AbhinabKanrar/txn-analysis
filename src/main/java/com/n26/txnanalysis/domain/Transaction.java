package com.n26.txnanalysis.domain;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Transaction {

	@NotNull
	private double amount;

	@NotNull
	private long timestamp;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}


	

}