package com.finahub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BankDemo {
	private static final Logger log = LoggerFactory.getLogger(BankDemo.class);

	public static void main(String[] args) {
		log.info("Spring Boot Application");
		SpringApplication.run(BankDemo.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Bean
	public HttpHeaders httpHeaders() {
	    return new HttpHeaders();
	}

}
