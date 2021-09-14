package com.finahub.coding.server.inter;

import java.util.List;

import org.json.JSONObject;

import com.finahub.coding.server.vo.BankInfo;

public interface BankOperationsInterface {
	
	public List<BankInfo> listAllBanks();
	
	public JSONObject getBankByName(String bankname);
	
	public JSONObject insertNewBank(JSONObject bankinfo);
	

}
