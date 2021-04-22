package com.neethu.controller;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neethu.model.Banks;
import com.neethu.repository.BankRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class BankController {

	//
	@Autowired
	private BankRepository bankRepository;
	
	
	@GetMapping("banks")
	//public List<User> getUsers()
	public String getUsers() throws IOException
	{
		//return this.userRepository.findAll();
		
                String a=getPersonData();
                System.out.print(a);
                return a;
      
	}

	public static String getPersonData() throws IOException{
		HttpURLConnection connection = (HttpURLConnection) new URL("https://api.airtable.com/v0/appL8W9qlf8sORhe6/Table%201/rech13ehAsm8D1XQX?api_key=keyt2v8O8zj3ZFt2s").openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();
		if(responseCode == 200){
			
	
			String response = "[";
			Scanner scanner = new Scanner(connection.getInputStream());
			while(scanner.hasNextLine()){
				response += scanner.nextLine();
				response += "\n";
			}
			
			response += "]";
			scanner.close();
	
			return response;
		}
		return null;
	}
	
	@PostMapping("banksave")
	@CrossOrigin(origins = "http://localhost:3000")
	public Banks createBank(@RequestBody Banks bank)
	{
		return this.bankRepository.save(bank);
	}
	
	@GetMapping("bankshow")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Banks> getUsersdd()
	{
		return this.bankRepository.findAll();
	}
	

}