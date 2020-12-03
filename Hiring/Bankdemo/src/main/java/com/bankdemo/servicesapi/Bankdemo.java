package com.bankdemo.servicesapi;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bankdemo.repo.Repository;

import bank.model.Bank;

@RestController
@RequestMapping(value = "/sampleRestApi")
public class Bankdemo {
	
	@Autowired
	Repository repo;
	
	@GetMapping("/fetchRecord")
	public ResponseEntity<Object> fetchRecord() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI("https://api.airtable.com/v0/appL8W9qlf8sORhe6/Table%201/rech13ehAsm8D1XQX");
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer keyCIca0nAcKMhjto");  
		 
		HttpEntity<Object> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<Object> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, Object.class);
		return result;
	}
	@PostMapping("/insertrecord")
	public ResponseEntity<Object> insertrecord(@RequestBody Bank request) {
		if(request !=null)
		return ResponseEntity.ok(repo.insertValues(request));
		else return ResponseEntity.ok("Please pass values to be inserted");
		
	}
}