package com.finahub.coding.server.vo;

public class BankInfo {
	private int bank_id;
	private String bankname=null;
	private String creditcardamount=null;
	private String debitcardamount=null;
	
	public int getBank_id() {
		return bank_id;
	}
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	
	public String getCreditcardamount() {
		return creditcardamount;
	}
	public void setCreditcardamount(String creditcardamount) {
		this.creditcardamount = creditcardamount;
	}
	public String getDebitcardamount() {
		return debitcardamount;
	}
	public void setDebitcardamount(String debitcardamount) {
		this.debitcardamount = debitcardamount;
	}
	@Override
	public String toString() {
		return "BankInfo [bank_id=" + bank_id + ", bankname=" + bankname + ", creditcardamount=" + creditcardamount
				+ ", debitcardamount=" + debitcardamount + "]";
	}
}
