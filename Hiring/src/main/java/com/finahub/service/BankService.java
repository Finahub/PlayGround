package com.finahub.service;

import com.finahub.pojo.Bank;

public interface BankService {
	public Bank saveBankDetails(Bank data);
	public Object getBankInfo();
}
