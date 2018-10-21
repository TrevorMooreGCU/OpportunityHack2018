package com.hackathon.services.data;

import java.util.List;

import com.hackathon.model.ColumnDataModel;
import com.hackathon.model.ColumnHeadModel;

public interface IImportDAO {

	public int insertTableName(String tableName);
	
	public boolean insertColumnNames(List<ColumnHeadModel> columnNames, String tableName);
	
	public boolean insertColumnData(List<ColumnDataModel> dataValues, String tableName);
	
	
	
	

	
	
	
	
}
