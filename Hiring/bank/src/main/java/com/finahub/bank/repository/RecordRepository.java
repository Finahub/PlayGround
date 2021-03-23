package com.finahub.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finahub.bank.entity.RecordEntity;

/**
 * Repository for recordEntity
 *
 */
@Repository
public interface RecordRepository extends JpaRepository<RecordEntity, String> {

}
