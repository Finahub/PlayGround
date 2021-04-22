package com.neethu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neethu.model.Banks;

@Repository
public interface BankRepository extends JpaRepository<Banks, Long> {

}
