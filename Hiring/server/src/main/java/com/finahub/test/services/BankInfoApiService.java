package com.finahub.test.services;


import com.finahub.test.Entity.BankInfo;
import com.finahub.test.Utils.Records;
import com.finahub.test.Repository.BankRepoistory;
import com.finahub.test.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class BankInfoApiService {

    private final RestTemplate restTemplate;

    @Autowired
    BankRepoistory bankRepoistory;

    public BankInfoApiService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Value("${api.key}")
    private String apiKey;

    final String url = "https://api.airtable.com/v0/appL8W9qlf8sORhe6/Table 1";

    public Records getRecord() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Authorization", "Bearer " + apiKey);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<Result> response = restTemplate.exchange(url, HttpMethod.GET, entity, Result.class);
        Random rand = new Random();
        return response.getBody().getRecords().get(rand.nextInt(response.getBody().getRecords().size() - 1));
    }

    public void postRecord(BankInfo bankInfo) {
        bankRepoistory.save(bankInfo);
    }
}
