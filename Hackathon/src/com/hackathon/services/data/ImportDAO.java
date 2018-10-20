package com.hackathon.services.data;

import java.util.List;

import com.hackathon.model.ColumnDataModel;
import com.hackathon.model.ColumnHeadModel;

public class ImportDAO implements IImportDAO {

	@Override
	public boolean insertTableName(String tableName) {


		
		
		return false;
	}

	@Override
	public boolean insertColumnNames(List<ColumnHeadModel> columnNames) {


		
		
		return false;
	}

	@Override
	public boolean insertColumnData(List<ColumnDataModel> dataValues) {


		
		
		/*
	    String sql = "INSERT INTO "
	        + "MY_TABLE "
	        + "(FIELD_1,FIELD_2,FIELD_3) "
	        + "VALUES " + "(?,?,?)";

	    getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

	        @Override
	        public void setValues(PreparedStatement ps, int i)
	            throws SQLException {

	            MyPojo myPojo = myPojoList.get(i);
	            ps.setString(1, myPojo.getField1());
	            ps.setString(2, myPojo.getField2());
	            ps.setString(3, myPojo.getField3());

	        }

	        @Override
	        public int getBatchSize() {
	            return myPojoList.size();
	        }
	    });*/
		
		
		
		return false;
	}



	
}
