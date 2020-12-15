package com.finahub.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fields {

	private String bank;

	private Integer creditCardCount;

	private Integer debitCardCount;

	public String getBank() {
		return bank;
	}

	@JsonProperty("Bank")
	public void setBank(String bank) {
		this.bank = bank;
	}

	public Integer getCreditCardCount() {
		return creditCardCount;
	}

	@JsonProperty("Credit Card Count")
	public void setCreditCardCount(Integer creditCardCount) {
		this.creditCardCount = creditCardCount;
	}

	public Integer getDebitCardCount() {
		return debitCardCount;
	}

	@JsonProperty("Debit Card Count")
	public void setDebitCardCount(Integer debitCardCount) {
		this.debitCardCount = debitCardCount;
	}

	@Override
	public String toString() {
		return "Fields [Bank=" + bank + ", creditCardCount=" + creditCardCount + ", debitCardCount=" + debitCardCount
				+ "]";
	}

	public Fields() {
		super();
	}

	public Fields(String bank, Integer creditCardCount, Integer debitCardCount) {
		super();
		this.bank = bank;
		this.creditCardCount = creditCardCount;
		this.debitCardCount = debitCardCount;
	}

}
