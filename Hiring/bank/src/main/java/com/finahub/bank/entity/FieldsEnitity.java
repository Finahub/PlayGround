/**
 * 
 */
package com.finahub.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class for fields entry
 *
 */
@Entity
public class FieldsEnitity {
	/**
	 * Unique id for identify field
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fieldId;
	
	/**
	 * Bank name
	 */
	private String bank;
	
	/**
	 * Credit card count
	 */
	private Integer creditCardCount;
	
	/**
	 * Debit card count
	 */
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
	public FieldsEnitity(String bank, Integer creditCardCount, Integer debitCardCount) {
		super();
		this.bank = bank;
		this.creditCardCount = creditCardCount;
		this.debitCardCount = debitCardCount;
	}

	/**
	 * 
	 */
	public FieldsEnitity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
