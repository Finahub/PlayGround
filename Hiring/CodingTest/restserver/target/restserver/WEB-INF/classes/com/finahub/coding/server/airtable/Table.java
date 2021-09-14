package com.finahub.coding.server.airtable;

import com.finahub.coding.server.vo.BankInfo;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Table <T> {
	
	private final String name;
	private final Class<T> type;
	
	private AirtableBase parent;
	
	private static final String MIME_TYPE_JSON = "application/json";

	public Table(String name, Class<T> type) {
		this.name = name;
        this.type = type;
	}

	public Table(String name, Class<T> type, AirtableBase base) {
	        this(name, type);
	        setParent(base);
	 }

	 
	public void setParent(AirtableBase airtableBase) {
		 this.parent = airtableBase;
		
	}
    public BankInfo find(final String bankname) throws Exception {

        BankInfo body;

        HttpResponse<BankInfo> response;
        try {
            response = Unirest.get(getTableEndpointUrl() + "/" + bankname)
                    .header("accept", MIME_TYPE_JSON)
                    .header("Authorization", getBearerToken())
                    .asObject(BankInfo.class);
        } catch (UnirestException e) {
            throw new Exception(e);
        }
        int code = response.getStatus();

        if (200 == code) {
            body = response.getBody();
        } else if (429 == code) {
            return find(bankname);
        } else {
            body = null;
        }
		return body;
    }
    
    private String getBearerToken() {
        return "Bearer " + base().airtable().apiKey();
    }
    
    private AirtableBase base() {
        return parent;
    }
    
    private String getTableEndpointUrl() {

        return base().airtable().endpointUrl() + "/" + base().name() + "/" + this.name;
    }

}
