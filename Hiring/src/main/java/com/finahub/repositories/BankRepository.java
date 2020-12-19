package com.finahub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.finahub.pojo.Bank;

@Repository
public interface BankRepository extends CrudRepository<Bank, Long>{

}
