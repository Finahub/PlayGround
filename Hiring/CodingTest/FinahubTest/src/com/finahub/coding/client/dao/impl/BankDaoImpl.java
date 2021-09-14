package com.finahub.coding.client.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finahub.coding.client.dao.BankDao;
import com.finahub.coding.client.vo.BankInfo;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class BankDaoImpl implements BankDao{

	@Override
	public JSONObject addBank(JSONObject bankinfo) {
		HttpResponse<JsonNode> response =null;
		
		try {
			response = Unirest.get("http://localhost:8080/restserver/rest/save/")
					  .header("Accept", "application/json")
					  .queryString("bankinfo", bankinfo)
					  .asJson();
		} catch (UnirestException e2) {
			e2.printStackTrace();
		}
		
		JsonNode responseContent = response.getBody();
		return responseContent.getObject();
	}

	@Override
	public List<BankInfo> listAllBank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankInfo findBank(String bankname) {
			
		HttpResponse<JsonNode> response =null;
		
		try {
			response = Unirest.get("http://localhost:8080/restserver/rest/getbank/")
					  .header("Accept", "application/json")
					  .queryString("bankname", bankname)
					  .asJson();
		} catch (UnirestException e2) {
			e2.printStackTrace();
		}
		
		com.fasterxml.jackson.databind.ObjectMapper mapper =
		    new com.fasterxml.jackson.databind.ObjectMapper();
		BankInfo bankNode = mapper.convertValue( response.getBody(), BankInfo.class);
		
		return bankNode;
	}
}
