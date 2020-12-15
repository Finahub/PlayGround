package com.finahub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finahub.dao.ApiResponse;
import com.finahub.dao.Records;
import com.finahub.entity.BankInfoEntity;
import com.finahub.service.BankService;
import com.finahub.util.ResponseUtil;

@RestController
@RequestMapping("/finahub")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BankInfoController {

	@Autowired
	BankService bankService;

	@GetMapping("/getBankInfo")
	public ResponseEntity<ApiResponse> getBankInfo() {
		Records result = bankService.getBankInfo();
		return ResponseUtil.getResponse(HttpStatus.OK, "Record Fetch Successfully....!!!", result);
	}
	
	@PostMapping("/saveBankInfo")
	public ResponseEntity<ApiResponse> saveBankInfo(@RequestBody List<BankInfoEntity> bnkInfo) {
		boolean result = bankService.postBankInfo(bnkInfo);
		if(result) {
			return ResponseUtil.getResponse(HttpStatus.OK, "Record Fetch Successfully....!!!");	
		}else {
			return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Record Insertion Failed....!!!");	
		}
		
	}

}
