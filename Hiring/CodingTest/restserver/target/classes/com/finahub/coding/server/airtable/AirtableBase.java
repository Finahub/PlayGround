package com.finahub.coding.server.airtable;

import java.util.HashMap;
import java.util.Map;

import com.finahub.coding.server.vo.BankInfo;

public class AirtableBase {


	@SuppressWarnings("rawtypes")
	private final Map<String, Table> tableMap = new HashMap<>();

	private final String baseName;

	private final Airtable parent;
	
	public AirtableBase(String val, Airtable airtable) {
		baseName=val;
		parent=airtable;
	}
	
    public Airtable airtable() {
        return parent;
    }

    @SuppressWarnings("rawtypes")
	public Table table(String name) {
        return table(name, BankInfo.class);
    }

 
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Table table(String name, Class clazz) {

        if(!tableMap.containsKey(name)) {
            Table t = new Table(name, clazz);
            t.setParent(this);
            tableMap.put(name, t);
        }

        return  tableMap.get(name);
    }


    public String name() {
        return baseName;
    }
}
