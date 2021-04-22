package com.neethu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="banks")

public class Banks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="bank")
	private String bank;
	@Column(name="credit_Card_Count")
	private String creditCardCount;
	@Column(name="debit_Card_Count")
	private String debitCardCount;
	
	public Banks(String bank, String creditCardCount, String debitCardCount) {
		super();
		this.bank = bank;
		this.creditCardCount = creditCardCount;
		this.debitCardCount = debitCardCount;
	}
	
	public Banks()
	{
		
	}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getCreditCardCount() {
		return creditCardCount;
	}
	public void setCreditCardCount(String creditCardCount) {
		this.creditCardCount = creditCardCount;
	}
	public String getDebitCardCount() {
		return debitCardCount;
	}
	public void setDebitCardCount(String debitCardCount) {
		this.debitCardCount = debitCardCount;
	}
		
}
	
