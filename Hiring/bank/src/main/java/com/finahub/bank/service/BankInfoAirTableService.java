package com.finahub.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.finahub.bank.model.Records;

/**
 * Service class for getting bank information.
 *
 */
@Service
public class BankInfoAirTableService {
	@Autowired
	private RestTemplate restTemplate;
	@Value("${app.service.endpoint}")
	private String endpoint;

	/**
	 * Method for getting bank information Returning records of bank data
	 */
	public Records getBankInfo() {

		HttpHeaders headers = new HttpHeaders();

		headers.set("Authorization", "Bearer key7QvSUkRqC7U1ab");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Records> ob = restTemplate.exchange(endpoint, HttpMethod.GET, entity, Records.class);
		return ob.getBody();
	}
}
