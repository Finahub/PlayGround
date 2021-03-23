/**
 * 
 */
package com.finahub.bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model class for getting bank details.
 *
 */
public class Fields {
	/**
	 * Bank name
	 */
	@JsonProperty("Bank")
	private String bank;
	/**
	 * Number of credit cards.
	 */
	@JsonProperty("Credit Card Count")
	private Integer creditCardCount;
	/**
	 * Number of debit card
	 */
	@JsonProperty("Debit Card Count")
	private Integer debitCardCount;

	public Integer getCreditCardCount() {
		return creditCardCount;
	}

	public void setCreditCardCount(Integer creditCardCount) {
		this.creditCardCount = creditCardCount;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Integer getDebitCardCount() {
		return debitCardCount;
	}

	public void setDebitCardCount(Integer debitCardCount) {
		this.debitCardCount = debitCardCount;
	}

	/**
	 * @param bank
	 * @param creditCardCount
	 * @param debitCardCount
	 */
	public Fields(String bank, Integer creditCardCount, Integer debitCardCount) {
		super();
		this.bank = bank;
		this.creditCardCount = creditCardCount;
		this.debitCardCount = debitCardCount;
	}

	/**
	 * 
	 */
	public Fields() {
		super();
		// TODO Auto-generated constructor stub
	}

}
