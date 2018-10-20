package com.hackathon.services.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.TableModel;
import com.hackathon.services.data.ISecurityDAO;
import com.hackathon.services.data.ITableDAO;

public class TableFormService implements ITableService {

	ITableDAO tableDAO;

	@Autowired
	public void setSecurityDAO(ITableDAO dao)
	{
		this.tableDAO = dao;
	}
	
	@Override
	public List<ColumnHeadModel> tableForm(TableModel table) {
		try{
			return tableDAO.tableForm(table);
		}catch(Exception e) {
			System.out.println("Database Exception. Caught in Employee Service.");
			return null;
		}
	}

}
