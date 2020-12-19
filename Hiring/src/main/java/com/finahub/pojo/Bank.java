package com.finahub.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@Column(name = "BANK_NAME", length = 50)
	private String bankName;
	@Column(name = "DEBIT_CARD_COUNT")
	private Integer debitCardCount;
	@Column(name = "CREDIT_CARD_COUNT")
	private Integer creditCardCount;

	public Bank() {
		super();

	}

	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Integer getDebitCardCount() {
		return debitCardCount;
	}

	public void setDebitCardCount(Integer debitCardCount) {
		this.debitCardCount = debitCardCount;
	}

	public Integer getCreditCardCount() {
		return creditCardCount;
	}

	public void setCreditCardCount(Integer creditCardCount) {
		this.creditCardCount = creditCardCount;
	}

}
