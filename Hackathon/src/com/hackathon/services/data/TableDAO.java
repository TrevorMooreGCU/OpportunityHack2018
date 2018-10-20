package com.hackathon.services.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.TableModel;

public class TableDAO implements ITableDAO {
	
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
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

	
	
}
