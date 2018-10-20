package com.hackathon.services.data;

import java.util.List;

import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.TableModel;

public interface ITableDAO {

	public List<ColumnHeadModel> tableForm(TableModel table);
	
}
