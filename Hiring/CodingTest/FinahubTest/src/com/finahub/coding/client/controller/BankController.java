package com.finahub.coding.client.controller;

import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finahub.coding.client.dao.BankDao;
import com.finahub.coding.client.vo.BankInfo;


@Controller
public class BankController {

	 @Autowired    
	 BankDao dao;    
	       
	    @RequestMapping("/ViewBank")    
	    public String showform(@PathVariable("bankname") String bankname, Model m){   
	    	BankInfo info= dao.findBank(bankname);
	        m.addAttribute("bankinfo", info);  
	        return "viewOneBank";   
	    }    
	    
	    @RequestMapping(value="/save",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("bankinfo") BankInfo bankinfo, Model m){ 
	    	
	    	JSONObject bankdeatils = new JSONObject();
	    	bankdeatils.append("bankname", bankinfo.getBankname());
	    	bankdeatils.append("creditcardamount", bankinfo.getCreditcardamount());
	    	bankdeatils.append("debitcardamount", bankinfo.getDebitcardamount());
	        JSONObject response = dao.addBank(bankdeatils);
	        m.addAttribute("saveRes", response);
	        return "index";    
	    }    
	    @RequestMapping("/addBank")
	    public String showBankPage(){   
	        return "redirect:/addBank";   
	    }  
	    
	    @RequestMapping("/viewBankInfo")
	    public String showBankInfoPage(){   
	        return "redirect:/searchBank";   
	    }  
	    
	    
	    /* It provides list of employees in model object */    
	    @RequestMapping("/vieAllwBankInfo")    
	    public String viewbank(Model m){    
	        List<BankInfo> list=dao.listAllBank();  
	        m.addAttribute("list",list);  
	        return "viewemp";    
	    } 
	    @RequestMapping("/index")    
	    public String viewhome(){    
	        return "index";    
	    } 
	    
	 }