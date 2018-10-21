package com.hackathon.services.data;

import java.util.ArrayList;
import java.util.List;

import com.hackathon.model.ColumnDataModel;
import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.TableModel;

public interface ITableDAO {

	public List<ColumnHeadModel> tableForm(TableModel table);
	
	public ArrayList<ColumnHeadModel> getColumns(TableModel table);
	
	public ArrayList<ColumnDataModel>getColumnData(int id, TableModel table);
	
}
