package com.n26.txnanalysis.domain;

import javax.validation.constraints.NotNull;

public class Transaction {

	@NotNull
	private Double amount;

	@NotNull
	private Long timestamp;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}