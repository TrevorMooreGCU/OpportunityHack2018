package com.hackathon.model;

public class ColumnDataModel {

	public int id;
	public int columnNameId;
	public String columnData;
	
	public ColumnDataModel(int id, int columnNameId, String columnData) {
		this.id = id;
		this.columnNameId = columnNameId;
		this.columnData = columnData;
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
	
}
