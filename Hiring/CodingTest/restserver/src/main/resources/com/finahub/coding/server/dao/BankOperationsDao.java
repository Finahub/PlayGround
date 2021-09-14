package com.finahub.coding.server.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.json.JSONObject;

import com.finahub.coding.server.airtable.Airtable;
import com.finahub.coding.server.airtable.AirtableBase;
import com.finahub.coding.server.airtable.AirtableConfiguration;
import com.finahub.coding.server.airtable.Table;
import com.finahub.coding.server.database.dbimpl.H2DBConnection;
import com.finahub.coding.server.inter.BankOperationsInterface;
import com.finahub.coding.server.utils.ErrorObject;
import com.finahub.coding.server.vo.BankInfo;

public class BankOperationsDao implements BankOperationsInterface {
	
	Connection h2connection = H2DBConnection.getH2B().getConnection();
	BankInfo bankinfo= new BankInfo();	
	String query_string=null;
	JSONObject responseObject = null;

	
	@Override
	public List<BankInfo> listAllBanks() {
		
		return null;
	}

	@Override
	public JSONObject getBankByName(String bankname) {
		
		Airtable airtable;
		JSONObject bankResponse= new JSONObject();
		try {
			airtable = new Airtable().configure();
			//AirtableBase base = new AirtableBase(base, airtable);	
			Table<BankInfo> bankTable = airtable.base().table("BANKINFO", BankInfo.class);
			BankInfo bankinfo = bankTable.find(bankname);
			bankResponse
					.append("bank_id", bankinfo.getBank_id())
					.append("bankname", bankinfo.getBankname())
					.append("creditcardamount", bankinfo.getCreditcardamount())
					.append("debitcardamount", bankinfo.getDebitcardamount());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankResponse;
	}

	@Override
	public JSONObject insertNewBank(JSONObject bankinfo) {
		try {
			Statement statement = h2connection.createStatement();
			if(bankinfo.getString("bankname")!=null && bankinfo.getDouble("creditcardamount")!=0 && bankinfo.getDouble("debitcardamount")!=0) {
				query_string = "insert into BANKINFO (Bank_Name, Credit_Card_Amount, Debit_Card_Amount) values ("
						+bankinfo.getString("bankname")+","+bankinfo.getDouble("creditcardamount")+","+bankinfo.getDouble("debitcardamount")+")";
				int result = statement.executeUpdate(query_string);
				if(result!=0) {
					responseObject= ErrorObject.getErrorObject().createJSONErrorObject(result, "data inserted successfully", null);
				}
			}
			
			if(query_string==null) {
				responseObject= ErrorObject.getErrorObject().createJSONErrorObject(101, "column values can not be null", null);
			}
		
		} catch (SQLException sqlex) {
			responseObject= ErrorObject.getErrorObject().createJSONErrorObject(201, "insertion exception", sqlex);
		}
		
		return responseObject;
	}

}
