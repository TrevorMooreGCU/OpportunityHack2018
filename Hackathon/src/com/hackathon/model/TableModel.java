package com.hackathon.model;
//Name of the table, decided by the user not by the CSV file
public class TableModel {

	public int id;
	public String tableName;
	
	public TableModel(int id, String tableName) {
		this.id = id;
		this.tableName = tableName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
	
	
}
