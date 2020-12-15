package com.finahub.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.finahub.dao.Records;
import com.finahub.entity.BankInfoEntity;
import com.finahub.repository.BankInfoRepository;

@TestInstance(Lifecycle.PER_CLASS)
class BankServiceImplTest {

	@Mock
	private BankInfoRepository bankRepo;
	
	@Mock
	private List<BankInfoEntity> bnkInfo;
	
	@Mock
	private Records records;
	
	@InjectMocks
	private BankServiceImpl bankService;
	
	@BeforeAll
	void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	void testPostBankInfo() {
		when(bankRepo.saveAll(bnkInfo)).thenReturn(bnkInfo);
		assertNotNull(bankService.postBankInfo(bnkInfo));
		verify(bankRepo,times(1)).saveAll(bnkInfo);
	}

}
