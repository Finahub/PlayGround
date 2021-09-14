package com.finahub.coding.server.airtable;

public class AirtableConfiguration {
	
	private String ENDPOINT_URL;
	private String AIRTABLE_BASE;
	private String AIRTABLE_API_KEY;
	private String AIRTABLE_PROXY;

	public AirtableConfiguration(String ENDPOINT_URL, String AIRTABLE_API_KEY) {
		this(ENDPOINT_URL,AIRTABLE_API_KEY,null);
	}
	
	public AirtableConfiguration(String ENDPOINT_URL, String AIRTABLE_API_KEY,String AIRTABLE_PROXY) {
		super();
		this.ENDPOINT_URL = ENDPOINT_URL;
		this.AIRTABLE_API_KEY = AIRTABLE_API_KEY;
		this.AIRTABLE_PROXY = AIRTABLE_PROXY;
	}
	
	public String getENDPOINT_URL() {
		return ENDPOINT_URL;
	}
	public void setENDPOINT_URL(String eNDPOINT_URL) {
		ENDPOINT_URL = eNDPOINT_URL;
	}
	public String getAIRTABLE_BASE() {
		return AIRTABLE_BASE;
	}
	public void setAIRTABLE_BASE(String aIRTABLE_BASE) {
		AIRTABLE_BASE = aIRTABLE_BASE;
	}
	public String getAIRTABLE_API_KEY() {
		return AIRTABLE_API_KEY;
	}
	public void setAIRTABLE_API_KEY(String aIRTABLE_API_KEY) {
		AIRTABLE_API_KEY = aIRTABLE_API_KEY;
	}
	public String getAIRTABLE_PROXY() {
		return AIRTABLE_PROXY;
	}
	public void setAIRTABLE_PROXY(String aIRTABLE_PROXY) {
		AIRTABLE_PROXY = aIRTABLE_PROXY;
	}
}
