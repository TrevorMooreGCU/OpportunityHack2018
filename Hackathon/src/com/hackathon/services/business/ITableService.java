package com.hackathon.services.business;

import java.util.List;

import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.TableModel;

public interface ITableService {

	public List<ColumnHeadModel> tableForm(TableModel table);
	
}
