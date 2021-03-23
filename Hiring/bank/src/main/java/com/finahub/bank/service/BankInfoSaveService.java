package com.finahub.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finahub.bank.entity.FieldsEnitity;
import com.finahub.bank.entity.RecordEntity;
import com.finahub.bank.model.Record;
import com.finahub.bank.repository.FieldsRepository;
import com.finahub.bank.repository.RecordRepository;

/**
 * Service class for record entity save operation.
 *
 */
@Service
public class BankInfoSaveService {

	/**
	 * Instance of Record repository.
	 */
	@Autowired
	private RecordRepository recordRepository;
	
	/**
	 * Instance of field Repository.
	 */
	@Autowired
	private FieldsRepository fieldsRepository;

	/**
	 * Method for save Record entity.
	 * 
	 * @param record Record data.
	 * 
	 * @return String Message for save operation.
	 */
	public String saveRecordEntity(Record record) {
		RecordEntity entity = new RecordEntity();
		entity.setId(record.getId());
		entity.setCreatedTime(record.getCreatedTime());
		FieldsEnitity fields = new FieldsEnitity();
		fields.setBank(record.getFields().getBank());
		fields.setCreditCardCount(record.getFields().getCreditCardCount());
		fields.setDebitCardCount(record.getFields().getDebitCardCount());
		
		try {
			fieldsRepository.save(fields);
			entity.setFields(fields);
			if (recordRepository.save(entity) != null) {
				return "Successfully saved";
			} else {
				return "Not saved";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Not saved";
	}
}