package com.n26.txnanalysis.domain;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Transaction {

	@NotNull
	private double amount;

	@NotNull
	private long timestamp;

}