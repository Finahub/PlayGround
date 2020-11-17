package com.finahub.test.Repository;

import com.finahub.test.Entity.BankInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepoistory extends CrudRepository<BankInfo,Integer> {
}
