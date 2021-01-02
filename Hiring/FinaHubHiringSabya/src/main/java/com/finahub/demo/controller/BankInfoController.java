package com.finahub.demo.controller;

import com.finahub.demo.BankInfoJson2Pojo;
import com.finahub.demo.Record;
import com.finahub.demo.dao.BankInfoDao;
import com.finahub.demo.model.BankInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class BankInfoController {

    private final RestTemplate restTemplate;

    @Autowired
    private BankInfoDao bankInfoDao;

    public BankInfoController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }



    @GetMapping("/banks")
    public List<BankInfo> getAllBanksInfo() throws URISyntaxException {
        URI uri = new URI("https://api.airtable.com/v0/appL8W9qlf8sORhe6/Table%201");
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+"keyk6ByaxpSiI0yXj");
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<BankInfoJson2Pojo> allBanksInfo = restTemplate.exchange(uri, HttpMethod.GET, request,
                BankInfoJson2Pojo.class);
        for (Record record: Objects.requireNonNull(allBanksInfo.getBody()).getRecords())
        {

        }

        List<BankInfo> list = new ArrayList<>();
        for (Record record : Objects.requireNonNull(allBanksInfo.getBody()).getRecords()) {
            BankInfo bankInfo = record.getBankInfo();
            list.add(bankInfo);
        }
        return  list;


    }

    @PostMapping ("/saveBankInfo")
    public BankInfo saveBankInfo(@RequestBody BankInfo bankInfo) throws URISyntaxException {

       bankInfoDao.save(bankInfo);

       return bankInfo;
    }

    @GetMapping("retrieveSavedBankInfo")
    public List<BankInfo> retrieveSavedBankInfo()
    {
        return bankInfoDao.findAll();
    }


}
