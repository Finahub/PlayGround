/**
 * 
 */
package com.finahub.bank.model;

import java.sql.Timestamp;

/**
 * Model class for getting field object.
 *
 */
public class Record {

	/**
	 * Unique id for identify fields.
	 */
	private String id;
	/**
	 * Bank details.
	 */
	private Fields fields;
	/**
	 * Record created Time.
	 */
	private Timestamp createdTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Fields getFields() {
		return fields;
	}

	public void setFields(Fields fields) {
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
	public Record(String id, Fields fields, Timestamp createdTime) {
		super();
		this.id = id;
		this.fields = fields;
		this.createdTime = createdTime;
	}

	/**
	 * 
	 */
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}

}
