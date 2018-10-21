package com.hackathon.services.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hackathon.model.EmployeeModel;
import com.hackathon.model.TableModel;
import com.hackathon.services.data.ISecurityDAO;
import com.hackathon.services.data.ITableNamesDAO;

public class TableNameService implements ITableNameService {

	ITableNamesDAO tableNamesDAO;

	@Autowired
	public void setSecurityDAO(ITableNamesDAO dao)
	{
		this.tableNamesDAO = dao;
	}
	
	@Override
	public List<TableModel> getTableNames() {
		return tableNamesDAO.TableNames();
	}

}
