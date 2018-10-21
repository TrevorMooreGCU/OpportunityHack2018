package com.hackathon.services.business;

import java.util.ArrayList;
import java.util.List;

import com.hackathon.model.ColumnDataModel;
import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.TableModel;

public interface ITableService {

	public List<ColumnHeadModel> tableForm(TableModel table);
	
	public List<ColumnHeadModel> getColumns(TableModel table);
	
	public int getNumberColumns(TableModel table);
	
	public ArrayList<ColumnDataModel>getColumnData(int id, TableModel table);
	
}
