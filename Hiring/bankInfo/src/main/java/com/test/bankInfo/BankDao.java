package com.test.bankInfo;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bankDao")
public class BankDao 
{
	@Autowired
	private SessionFactory sessionfactory;
	
	 public List<BankModel> getBanks()
	 {
		 return sessionfactory.getCurrentSession().createCriteria(BankModel.class).list();
	 }
	 
	 public void save(BankModel user)  
	 {  
		sessionfactory.getCurrentSession().saveOrUpdate(user);  
	 }
	 
	 public int delete(Integer id)
	 {
			
		String query = "delete from tbl_bank where id = "+id;
		int status = sessionfactory.getCurrentSession().createSQLQuery(query).executeUpdate();
		return status;
			
	 }
		
	 public BankModel getBank(Integer id)
	 {
		 BankModel user = (BankModel) sessionfactory.getCurrentSession().get(BankModel.class, id);
		return user;
	 }

}
