package com.finahub.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finahub.bank.entity.FieldsEnitity;

/**
 * Repository for field entity
 *
 */
@Repository
public interface FieldsRepository extends JpaRepository<FieldsEnitity, Integer> {

}
