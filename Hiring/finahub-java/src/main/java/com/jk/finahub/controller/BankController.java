package com.jk.finahub.controller;

import com.google.gson.Gson;
import com.jk.finahub.service.BankService;
import com.jk.finahub.dto.BankDTO;
import com.jk.finahub.model.ApiResponse;
import com.jk.finahub.model.Fields;
import com.jk.finahub.model.Record;
import com.jk.finahub.repo.BankRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/banks")
public class BankController {

    private static final Logger log = LoggerFactory.getLogger(BankController.class);

    @Autowired
    BankRepo bankRepo;

    @GetMapping
    public Flux<BankDTO> getAllBanks() {
        log.info("list all banks");
        return bankRepo.findAll();
    }

    @GetMapping("/{id}")
    public Mono<BankDTO> getBank(@PathVariable Integer id) {
        return bankRepo.findById(id);
    }

    @PostMapping
    public Mono<BankDTO> createBank(@RequestBody BankDTO bank) {
        log.info(bank.getBank());
        return bankRepo.save(bank);
    }

    @PutMapping("/{id}")
    public Mono<BankDTO> updateBank(@RequestBody BankDTO bank, @PathVariable Integer id) {
        return bankRepo.findById(id)
                .map(bankDTO -> {
                    bankDTO.setBank(bank.getBank());
                    return bankDTO;
                }).flatMap(bankDTO -> bankRepo.save(bankDTO));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteBank(@PathVariable Integer id) {
        return bankRepo.deleteById(id);
    }


    @Autowired
    private BankService bankService;

    @GetMapping("/airtable")
    public Flux<String> getBanks() {
        return bankService.getBanks();
    }

    @GetMapping("/airtable/random")
    public Mono<Fields> getBankRandom() {
        Flux<String> banks = bankService.getBanks();
        Gson gson = new Gson();
        return banks.map(json -> gson.fromJson(json, ApiResponse.class))
                .map(records -> {
                    List<Record> temp = records.getRecords();
                    Random rand = new Random();
                    return temp.get(rand.nextInt(temp.size())).getFields();
                }).singleOrEmpty();
    }
}
