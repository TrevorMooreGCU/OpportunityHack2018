package com.hackathon.services.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.hackathon.model.ColumnDataModel;
import com.hackathon.model.ColumnHeadModel;

public class ImportDAO implements IImportDAO {

	DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	@Override
	public int insertTableName(String tableName) {
		// TODO Auto-generated method stub

		String query = "INSERT INTO nod3eke2u33fhtk2.tablenametable (TABLE_NAME) VALUES (?)";

		KeyHolder key = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, tableName);
				return ps;
			}
		}, key);

		return key.getKey().intValue();

	}

	@Override
	public boolean insertColumnNames(List<ColumnHeadModel> columnNames, String tableName) {

		tableName = tableName + "_columns";

		// create table with
		String createTableQuery = "CREATE TABLE " + tableName + " (" 
		+ "  ID int(11) NOT NULL AUTO_INCREMENT,"
		+ "  TABLE_NAME_ID int(11) NOT NULL," 
		+ "  COLUMN_NAME varchar(100) NOT NULL,"
		+ "  PRIMARY KEY (ID)," 
		+ "  FOREIGN KEY fk_" + tableName + "_id(TABLE_NAME_ID)"
		+ "  REFERENCES tablenametable(ID) ON DELETE CASCADE"
		+ ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";

		jdbcTemplate.execute(createTableQuery);

		for (ColumnHeadModel columnHeadModel : columnNames) {
			String query = "INSERT INTO nod3eke2u33fhtk2." + tableName + " (TABLE_NAME_ID, COLUMN_NAME) VALUES (?, ?)";
			int result = jdbcTemplate.update(query, columnHeadModel.getTableNameId(), columnHeadModel.getColumnName());

		}

		return true;
	}

	@Override
	public boolean insertColumnData(List<ColumnDataModel> dataValues, String tableName) {
		// TODO Auto-generated method stub
		
		String columnsTableName = tableName + "_columns";
				
		tableName = tableName + "_data";
		

		String createTableQuery = "CREATE TABLE " + tableName + " (" 
			+ "  ID int(11) NOT NULL AUTO_INCREMENT,"
			+ "  TABLE_NAME_ID int(11) NOT NULL," 
			+ "  COLUMN_ID int(11) NOT NULL," 
			+ "  COLUMN_DATA varchar(100) NOT NULL,"
			+ "  PRIMARY KEY (ID)," 
			+ "  FOREIGN KEY fk_" + tableName + "_id(TABLE_NAME_ID)"
			+ "  REFERENCES tablenametable(ID) ON DELETE CASCADE"
			+ ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";

		jdbcTemplate.execute(createTableQuery);

		
		String sql = "INSERT INTO " + tableName + " " + "(TABLE_NAME_ID,COLUMN_DATA, COLUMN_ID) " + "VALUES " + "(?,?, ?)";

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ColumnDataModel dataValue = dataValues.get(i);
				
				ps.setInt(1, dataValue.getTableNameId());
				ps.setString(2, dataValue.getColumnData());
				ps.setInt(3, dataValue.getColumnNameId());
			}

			@Override
			public int getBatchSize() {
				return dataValues.size();
			}
		});

		return true;
	}

	/*
	 * String sql = "INSERT INTO " + "MY_TABLE " + "(FIELD_1,FIELD_2,FIELD_3) " +
	 * "VALUES " + "(?,?,?)";
	 * 
	 * getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
	 * 
	 * @Override public void setValues(PreparedStatement ps, int i) throws
	 * SQLException {
	 * 
	 * MyPojo myPojo = myPojoList.get(i); ps.setString(1, myPojo.getField1());
	 * ps.setString(2, myPojo.getField2()); ps.setString(3, myPojo.getField3());
	 * 
	 * }
	 * 
	 * @Override public int getBatchSize() { return myPojoList.size(); } });
	 */

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
