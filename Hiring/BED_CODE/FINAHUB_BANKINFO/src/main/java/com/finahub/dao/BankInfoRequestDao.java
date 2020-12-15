package com.finahub.dao;

import java.math.BigDecimal;

import javax.persistence.Column;

public class BankInfoRequestDao {
	
	private String bankName;

	private BigDecimal crdtCrdCount;

	private BigDecimal dbtCrdCount;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public BigDecimal getCrdtCrdCount() {
		return crdtCrdCount;
	}

	public void setCrdtCrdCount(BigDecimal crdtCrdCount) {
		this.crdtCrdCount = crdtCrdCount;
	}

	public BigDecimal getDbtCrdCount() {
		return dbtCrdCount;
	}

	public void setDbtCrdCount(BigDecimal dbtCrdCount) {
		this.dbtCrdCount = dbtCrdCount;
	}

	public BankInfoRequestDao() {
		super();
	}

	@Override
	public String toString() {
		return "BankInfoRequestDao [bankName=" + bankName + ", crdtCrdCount=" + crdtCrdCount + ", dbtCrdCount="
				+ dbtCrdCount + "]";
	}

}
