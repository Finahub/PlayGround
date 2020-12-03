package com.bankdemo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import bank.model.Bank;

@org.springframework.stereotype.Repository
public class Repository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	

	public String insertValues(Bank request) {
		String sql = "insert into banktable (bank, credit_card_count, debit_card_count) values (?,?,?)";
		try {
			jdbcTemplate.update(sql, new Object[] {request.getBank(), request.getCredit_card_count(), request.getDebit_card_count()});
		} catch(Exception e) {
			return "Insert Failure";
		}
		return "Insert Success";
	}
		
	}



