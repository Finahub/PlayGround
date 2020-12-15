package com.finahub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finahub.entity.BankInfoEntity;

@Repository
public interface BankInfoRepository extends JpaRepository<BankInfoEntity, String> {

}
