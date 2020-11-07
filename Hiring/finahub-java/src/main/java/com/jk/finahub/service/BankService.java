package com.jk.finahub.service;

import com.jk.finahub.controller.BankController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Service
public class BankService {
    private final Logger log = LoggerFactory.getLogger(BankController.class);
    private final WebClient webClient;
    private final String API_URL = "https://api.airtable.com";
    private final String END_POINT = "/v0/appL8W9qlf8sORhe6/Table%201?api_key={apikey}";
    private final String KEY = "keyqeC92K0iClxcEY";
    ExchangeFilterFunction loggingFilter = (clientRequest, nextFilter) -> {
        log.info("Sending request " + clientRequest.method() + " " + clientRequest.url());
        return nextFilter.exchange(clientRequest);
    };

    public BankService(){
        webClient = WebClient.builder()
                .baseUrl(API_URL) //No Headers
                .filter(loggingFilter)
                .build();
    }
    public Flux<String> getBanks()  {
        try {
            String decodedURL = URLDecoder.decode(END_POINT, "UTF-8");
            return webClient.get()
                    .uri(decodedURL, KEY)
                    .exchange()
                    .flatMapMany(clientResponse -> clientResponse.bodyToFlux(String.class));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return Flux.just("{}}");

    }
}
