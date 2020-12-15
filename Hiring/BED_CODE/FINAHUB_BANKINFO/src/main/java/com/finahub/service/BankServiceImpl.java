package com.finahub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.finahub.dao.Records;
import com.finahub.entity.BankInfoEntity;
import com.finahub.repository.BankInfoRepository;

@Service
public class BankServiceImpl implements BankService {
	
	@Autowired
	BankInfoRepository bankRepo;

	@Override
	public Records getBankInfo() {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + "keywa1ceXnKMLXxMx");
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		ResponseEntity<Records> record = restTemplate.exchange("https://api.airtable.com/v0/appL8W9qlf8sORhe6/Table 1",
				HttpMethod.GET, entity, Records.class);
		return record.getBody();
	}

	@Override
	public boolean postBankInfo(List<BankInfoEntity> bnkInfo) {
		bankRepo.saveAll(bnkInfo);
		return true;
	}

}
