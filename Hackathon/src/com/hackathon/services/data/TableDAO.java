package com.hackathon.services.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.hackathon.model.ColumnDataModel;
import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.TableModel;

public class TableDAO implements ITableDAO {
	
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<ColumnHeadModel> tableForm(TableModel table) {
		// TODO Auto-generated method stub
		
		String query = "SELECT * FROM columnnametable WHERE TABLE_NAME_ID = ?";
		
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, table.id);
		
		List<ColumnHeadModel> columns = new ArrayList<ColumnHeadModel>();
		
		while(srs.next()) {
			
			ColumnHeadModel column = new ColumnHeadModel(srs.getInt("ID"),srs.getInt("TABLE_NAME_ID"), srs.getString("COLUMN_NAME"));
			columns.add(column);
			
		}
		
		return columns;
	}
	
	
	@Override
	public ArrayList<ColumnHeadModel> getColumns(TableModel table) 
	{
		String query = "SELECT * FROM "+table.getTableName()+"_columns";
		
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, table.getId());
		
		ArrayList<ColumnHeadModel> columns = new ArrayList<ColumnHeadModel>();
		
		while(srs.next()) 
		{
			System.out.println(srs.getInt("ID") + srs.getInt("TABLE_NAME_ID") + srs.getString("COLUMN_NAME"));
			columns.add(new ColumnHeadModel(srs.getInt("ID"),srs.getInt("TABLE_NAME_ID"), srs.getString("COLUMN_NAME")));
		}
		
		return columns;
	}
	
	@Override
	public int getNumberColumns(TableModel table)
	{
		String query1 = "SELECT * FROM "+table.getTableName()+"_columns";
		String query2 = "SELECT * FROM "+table.getTableName()+"_data";
		
		SqlRowSet srs1 = jdbcTemplate.queryForRowSet(query1, table.getId());
		SqlRowSet srs2 = jdbcTemplate.queryForRowSet(query2, table.getId());
		
		int i = 0;
		while(srs1.next()) 
			i++;
		
		int j = 0;
		while(srs2.next()) 
			j++;
		
		return j / i;
	}
	
	@Override
	public ColumnDataModel getColumnData(int id, int columnid, TableModel table)
	{
		String query = "SELECT * FROM "+table.getTableName()+"_data WHERE ID = ? AND COLUMN_ID = ?";
		
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, id, columnid);
		
		while(srs.next()) 
			return new ColumnDataModel(srs.getInt("ID"),table.getId(),srs.getInt("COLUMN_ID"), srs.getString("COLUMN_DATA"));
		
		return null;
	}

	
	
}
