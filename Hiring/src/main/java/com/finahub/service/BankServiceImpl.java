package com.finahub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.finahub.pojo.Bank;
import com.finahub.repositories.BankRepository;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	BankRepository bankdao;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	HttpHeaders httpHeaders;

	@Override
	public Bank saveBankDetails(Bank data) {
		try {
			return bankdao.save(data);
		} catch (Exception e) {
			throw new RuntimeException(e.getCause());
		}

	}

	@Override
	public Object getBankInfo() {
		httpHeaders.set("Authorization", "Bearer keytVcdUV7ShqqdCe");
		HttpEntity<Object> requestEntity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Object> result = restTemplate.exchange("https://api.airtable.com/v0/appL8W9qlf8sORhe6/Table 1/rech13ehAsm8D1XQX", HttpMethod.GET, requestEntity, Object.class);
		return result.getBody();
	}

}
