package com.finahub.dao;

public class BankInfoDao {

	private Fields fields;

	public Fields getFields() {
		return fields;
	}

	public void setFields(Fields fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "BankInfoDao [fields=" + fields + "]";
	}

	public BankInfoDao() {
		super();
	}

	public BankInfoDao(String id, Fields fields, String createdTime) {
		super();
		this.fields = fields;
	}

}
