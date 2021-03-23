package com.finahub.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.finahub.bank.model.Record;
import com.finahub.bank.model.Records;
import com.finahub.bank.service.BankInfoAirTableService;
import com.finahub.bank.service.BankInfoSaveService;

/**
 * Controller class for fetching bank data from air table and save to h2 db.
 *
 */

@Controller
public class BankController {
	@Autowired
	private BankInfoAirTableService bankInfoAirTableService;

	@Autowired
	private BankInfoSaveService bankInfoSaveService;

	/**
	 * Getting bank data from air table
	 * 
	 * @Return bank records.
	 */
	@GetMapping("/getbankinfo")
	public String getBankInfo(Model model) {
		Records records = bankInfoAirTableService.getBankInfo();
		Record record = records.getRecords().stream().findAny().get();
		model.addAttribute("recordEntity", record);
		return "index";
	}

	/**
	 * Save record entity to h2 db.
	 * 
	 * @param recordEntity from front end
	 * @return to save page.
	 */
	@PostMapping("/savebankinfo")
	String saveRecord(Record recordEntity, BindingResult result, Model model) {
		bankInfoSaveService.saveRecordEntity(recordEntity);
		return "saved";
	}
}
