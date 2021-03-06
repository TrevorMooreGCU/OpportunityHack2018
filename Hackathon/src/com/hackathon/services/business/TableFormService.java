package com.hackathon.services.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hackathon.model.ColumnDataModel;
import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.TableModel;
import com.hackathon.services.data.ISecurityDAO;
import com.hackathon.services.data.ITableDAO;

public class TableFormService implements ITableService {

	ITableDAO tableDAO;

	@Autowired
	public void setTableDAO(ITableDAO dao)
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
	
	
	
	
	@Override
	public ArrayList<ColumnHeadModel> getColumns(TableModel table) {
		try{
			return tableDAO.getColumns(table);
		}catch(Exception e) {
			System.out.println("Database Exception. Caught in Employee Service.");
			return null;
		}
	}
	
	@Override
	public int getNumberRows(TableModel table)
	{
		try{
			return tableDAO.getNumberRows(table);
		}catch(Exception e) {
			System.out.println("Database Exception. Caught in Employee Service.");
			return 0;
		}
	}
	
	@Override
	public int getNumberColumns(TableModel table)
	{
		try{
			return tableDAO.getNumberColumns(table);
		}catch(Exception e) {
			System.out.println("Database Exception. Caught in Employee Service.");
			return 0;
		}
	}
	
	@Override
	public ColumnDataModel getColumnData(int id, int columnid, TableModel table)
	{
		try{
			return tableDAO.getColumnData(id, columnid, table);
		}catch(Exception e) {
			System.out.println("Database Exception. Caught in Employee Service.");
			return null;
		}
	}

}
