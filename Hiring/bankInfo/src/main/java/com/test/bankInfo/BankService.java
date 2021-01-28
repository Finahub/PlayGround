package com.test.bankInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("bankService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BankService 
{
	@Autowired
	private BankDao bankDao;
	
	public List<BankModel> getBanks()
	{
		 return  bankDao.getBanks();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(BankModel user)
	{
		bankDao.save(user);
	}
	
	public int delete(int id)
	{
		 return bankDao.delete(id);
	}
	
	public BankModel getBank(int id)
	{
		BankModel employee = (BankModel) bankDao.getBank(id);
		return employee;
	}
}
