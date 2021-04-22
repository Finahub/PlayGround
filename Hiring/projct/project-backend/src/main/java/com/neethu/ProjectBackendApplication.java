package com.neethu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neethu.repository.BankRepository;


@SpringBootApplication
public class ProjectBackendApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ProjectBackendApplication.class, args);
	}
	@Autowired
	private BankRepository bankRepository;
	
}
