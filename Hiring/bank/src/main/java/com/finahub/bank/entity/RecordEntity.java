/**
 * 
 */
package com.finahub.bank.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity class for record entry
 *
 */
@Entity
public class RecordEntity {
	/**
	 * Unique id for identify records
	 */
	@Id
	private String id;
	/**
	 * The field for getting bank details
	 */
	@OneToOne(targetEntity = FieldsEnitity.class)
	private FieldsEnitity fields;
	/**
	 * The created time for each record.
	 */
	private Timestamp createdTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FieldsEnitity getFields() {
		return fields;
	}

	public void setFields(FieldsEnitity fields) {
		this.fields = fields;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @param id
	 * @param fields
	 * @param createdTime
	 */
	public RecordEntity(String id, FieldsEnitity fields, Timestamp createdTime) {
		super();
		this.id = id;
		this.fields = fields;
		this.createdTime = createdTime;
	}

	/**
	 * 
	 */
	public RecordEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
