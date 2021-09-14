package com.finahub.coding.client.dao;

import org.json.JSONObject;
import com.finahub.coding.client.vo.BankInfo;
import java.util.List;


public interface BankDao {
	JSONObject addBank(JSONObject bankinfo);
	List<BankInfo> listAllBank();
	BankInfo findBank(String bankname);
}