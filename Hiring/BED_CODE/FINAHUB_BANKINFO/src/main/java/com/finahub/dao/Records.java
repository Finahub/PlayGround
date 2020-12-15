package com.finahub.dao;

import java.util.List;

public class Records{
	
	private List<BankInfoDao> records;

	
	
	public List<BankInfoDao> getRecords() {
		return records;
	}



	public void setRecords(List<BankInfoDao> records) {
		this.records = records;
	}

	


	public Records() {
		super();
	}

	
	public Records(List<BankInfoDao> records) {
		super();
		this.records = records;
	}



	@Override
	public String toString() {
		return "Records [records=" + records + "]";
	}
	
	

}
