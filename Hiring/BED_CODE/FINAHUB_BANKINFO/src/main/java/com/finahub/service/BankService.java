package com.finahub.service;

import java.util.List;

import com.finahub.dao.Records;
import com.finahub.entity.BankInfoEntity;

public interface BankService {

	public Records getBankInfo();

	public boolean postBankInfo(List<BankInfoEntity> bnkInfo);

}
