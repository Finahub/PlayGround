package com.finahub.test.controllers;

import com.finahub.test.Entity.BankInfo;
import com.finahub.test.Utils.Records;
import com.finahub.test.services.BankInfoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class BankInfoApiController {

    @Autowired
    private BankInfoApiService service;

    @GetMapping
    public Records listRecord() {
        return service.getRecord();
    }

    @PostMapping("/bankInfo")
    public void saveRecord(@RequestBody BankInfo bankInfo) {
        service.postRecord(bankInfo);
    }
}
