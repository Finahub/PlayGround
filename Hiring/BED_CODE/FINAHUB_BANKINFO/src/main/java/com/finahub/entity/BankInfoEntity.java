package com.finahub.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BankInfo")
public class BankInfoEntity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "Bank")
	private String bankName;

	@Column(name = "CreditCardCount")
	private BigDecimal crdtCardCount;

	@Column(name = "DebitCardCount")
	private BigDecimal dbtCardCount;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getCrdtCardCount() {
		return crdtCardCount;
	}

	public void setCrdtCardCount(BigDecimal crdtCardCount) {
		this.crdtCardCount = crdtCardCount;
	}

	public BigDecimal getDbtCardCount() {
		return dbtCardCount;
	}

	public void setDbtCardCount(BigDecimal dbtCardCount) {
		this.dbtCardCount = dbtCardCount;
	}
	
	public BankInfoEntity() {
		super();
	}

	@Override
	public String toString() {
		return "BankInfoEntity [id=" + id + ", bankName=" + bankName + ", crdtCardCount=" + crdtCardCount
				+ ", dbtCardCount=" + dbtCardCount + "]";
	}

}
