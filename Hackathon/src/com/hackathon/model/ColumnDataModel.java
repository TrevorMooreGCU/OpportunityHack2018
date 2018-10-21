package com.hackathon.model;

public class ColumnDataModel {

	public int id;
	public int columnNameId;
	public String columnData;
	public int tableNameId;
	
	public ColumnDataModel(int id, int tableNameId, int columnNameId, String columnData) {
		this.id = id;
		this.columnNameId = columnNameId;
		this.columnData = columnData;
		this.tableNameId = tableNameId;
	}
	
	public ColumnDataModel() {
		this.id = 0;
		this.columnNameId = 0;
		this.columnData = "";
		this.tableNameId = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getColumnNameId() {
		return columnNameId;
	}

	public void setColumnNameId(int columnNameId) {
		this.columnNameId = columnNameId;
	}

	public String getColumnData() {
		return columnData;
	}

	public void setColumnData(String columnData) {
		this.columnData = columnData;
	}

	public int getTableNameId() {
		return tableNameId;
	}

	public void setTableNameId(int tableNameId) {
		this.tableNameId = tableNameId;
	}
	
}
