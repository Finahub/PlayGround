package com.finahub.demo.dao;

import com.finahub.demo.model.BankInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankInfoDao extends JpaRepository<BankInfo, String> {
}
