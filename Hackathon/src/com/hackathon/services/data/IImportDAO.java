package com.hackathon.services.data;

import java.util.List;

import com.hackathon.model.ColumnDataModel;
import com.hackathon.model.ColumnHeadModel;

public interface IImportDAO {

	public boolean insertTableName(String tableName);
	
	public boolean insertColumnNames(List<ColumnHeadModel> columnNames);
	
	public boolean insertColumnData(List<ColumnDataModel> dataValues);
	
	
	
	

	
	
	
	
}
