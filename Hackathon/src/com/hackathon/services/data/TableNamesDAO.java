package com.hackathon.services.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.hackathon.model.TableModel;

public class TableNamesDAO implements ITableNamesDAO {

	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<TableModel> TableNames() {
		
		String query = "SELECT * FROM tablenametable;";
		
		List<TableModel> tables = new ArrayList<TableModel>();
		
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);
		
		while(srs.next()) {
			
			TableModel table = new TableModel(srs.getString("ID"),srs.getString("TABLE_NAME"));
			tables.add(table);
			
		}
		
		return tables;
		
		
		
	}

}
