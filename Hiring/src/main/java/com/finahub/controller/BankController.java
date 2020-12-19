package com.finahub.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finahub.pojo.Bank;
import com.finahub.service.BankService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BankController {
	@Autowired
	BankService bankService;

	@GetMapping("/")
	public String hello() {
		System.out.println("Hello World");
		return "Hello, World!";
	}

	@PostMapping(value = "/save-bank-info")
	public ResponseEntity<String> saveBank(@RequestBody Bank bank) {
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.set("Content-Type","application/json");
		try {
			bankService.saveBankDetails(bank);
			return ResponseEntity.ok().headers(responseHeader).body("Insertion Successful");
		} catch (Exception ex) {
			return ResponseEntity.badRequest().headers(responseHeader).body("Insertion Fail");
		}

	}

	@GetMapping("/get-bank-info")
	public ResponseEntity<Object> getBankRecord() throws URISyntaxException {
		Object bank= bankService.getBankInfo();
		return ResponseEntity.ok().body(bank);
	}

}
