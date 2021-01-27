package com.test.bankInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class BankController 
{
	@Autowired
	private BankService bankService;
	
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public String test(ModelMap model) 
	{
	      //model.addAttribute("message", "Hello Spring MVC Framework!");
	      return "testing";
	}
	
	@RequestMapping(value = "addDetails", method = RequestMethod.GET)
	public ModelAndView gotoAdd(ModelMap model) 
	{
		/*return new ModelAndView("add_employee","command", model);*/
		Map<String, Object> models = new HashMap<String, Object>();
		models.put("heading", "Add New Bank Details");
		models.put("buttonLabel", "Save");
		models.put("bank", new BankModel());
	    return new ModelAndView("add_details", models);
	}
	
	@RequestMapping(value = {"save","editDetails/save"}, method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("bank")BankModel bank) 
	{
		 bankService.save(bank);
		 return new ModelAndView("redirect:/viewDetails");
	}
	
	@RequestMapping(value = "deleteDetails/{id}", method = RequestMethod.GET)
	public ModelAndView deleteData(@PathVariable Integer id) 
	{
		bankService.delete(id);
		 return new ModelAndView("redirect:/viewDetails");
	}
	
	@RequestMapping(value = "viewDetails", method = RequestMethod.GET)
	public ModelAndView gotoView(ModelMap model) 
	{
	       
	        List<BankModel> list = bankService.getBanks();
	        ModelAndView modeldata = new ModelAndView("list_details");
	        modeldata.addObject("banks", list);
	        return modeldata;
	}
	
	@RequestMapping(value = "editDetails/{id}", method = RequestMethod.GET)
	public ModelAndView editEmployee(@PathVariable Integer id,Map<String, Object> model) 
	{
		BankModel employee = (BankModel) bankService.getBank(id);
		model.put("heading", "Edit Bank Details");
		model.put("buttonLabel", "Update");
		model.put("bank", employee);
        return new ModelAndView("add_details",model);
		
		/*return new ModelAndView("add_employee","command",employee);*/
		
	}
	

	
}
