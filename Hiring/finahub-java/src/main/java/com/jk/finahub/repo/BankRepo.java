package com.jk.finahub.repo;

import com.jk.finahub.dto.BankDTO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BankRepo extends ReactiveCrudRepository<BankDTO,Integer> {
}
