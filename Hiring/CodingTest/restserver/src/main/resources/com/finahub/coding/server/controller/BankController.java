package com.finahub.coding.server.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finahub.coding.server.dao.BankOperationsDao;
import com.finahub.coding.server.database.dbimpl.H2DBConnection;

@RestController
public class BankController {
	
	@Autowired
	BankOperationsDao bankoperations;
	
	 @RequestMapping(value="/save/{bankinfo}", method = RequestMethod.POST)
	    @ResponseBody
	    public JSONObject saveBank(@PathVariable("bankinfo") JSONObject bankinfo){
		 	return bankoperations.insertNewBank(bankinfo);
	    }
	 @RequestMapping(value="/getbank/{bankname}", method=RequestMethod.GET)
	    @ResponseBody
	    public JSONObject getBank(@PathVariable("bankname") String bankname){
		 	return bankoperations.getBankByName(bankname);
	    }
}
