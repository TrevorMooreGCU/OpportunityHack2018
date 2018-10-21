package com.hackathon.services.business;

import java.util.List;

import com.hackathon.model.EmployeeModel;
import com.hackathon.model.TableModel;

public interface ITableNameService {

	public List<TableModel> getTableNames();
	
}
