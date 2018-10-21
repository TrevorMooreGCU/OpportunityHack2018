package com.hackathon.model;

import java.util.ArrayList;

public class ColumnDataModelListWrapper {

	
	private ArrayList<ColumnDataModel> columnDataModels;

	private String tableName;
	
	
	public ArrayList<ColumnDataModel> getColumnDataModels() 
	{
	    return columnDataModels;
	}

	public void setColumnDataModels(ArrayList<ColumnDataModel> columnDataModels) 
	{
	    this.columnDataModels = columnDataModels;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	

}
