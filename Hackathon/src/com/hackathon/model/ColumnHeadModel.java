package com.hackathon.model;

public class ColumnHeadModel {

	public int id;
	public int tableNameId;
	public String columnName;
	
	public ColumnHeadModel(int id, int tableNameId, String columnName) {
		this.id = id;
		this.tableNameId = tableNameId;
		this.columnName = columnName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTableNameId() {
		return tableNameId;
	}

	public void setTableNameId(int tableNameId) {
		this.tableNameId = tableNameId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
}
