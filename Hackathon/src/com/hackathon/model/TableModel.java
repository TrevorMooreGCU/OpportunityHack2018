package com.hackathon.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Name of the table, decided by the user not by the CSV file
public class TableModel {

	public int id;
	
	@NotNull(message="TableName cannot be left blank.")
	@Size(min=2, max=25, message="Must be between 2 and 100 characters.")
	public String tableName;
	
	public TableModel() {
		this.id = 0;
		this.tableName = "";
	}
	
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
