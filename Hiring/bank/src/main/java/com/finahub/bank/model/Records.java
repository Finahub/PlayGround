/**
 * 
 */
package com.finahub.bank.model;

import java.util.List;

/**
 * Model class for getting list of record.
 *
 */
public class Records {

	/**
	 * List of records.
	 */
	private List<Record> records;

	/**
	 * @return the records
	 */
	public List<Record> getRecords() {
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public void setRecords(List<Record> records) {
		this.records = records;
	}

	/**
	 * @param records
	 */
	public Records(List<Record> records) {
		super();
		this.records = records;
	}

	/**
	 * 
	 */
	public Records() {
		super();
		// TODO Auto-generated constructor stub
	}

}
