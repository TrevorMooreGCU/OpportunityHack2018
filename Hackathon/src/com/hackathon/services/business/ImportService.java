









package com.hackathon.services.business;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import com.hackathon.model.CredentialModel;
import com.hackathon.model.EmployeeModel;
import com.hackathon.services.data.IImportDAO;
import com.hackathon.services.data.ISecurityDAO;

public class ImportService implements IImportService
{

	IImportDAO importDAO;
	
	
	@Override
	public boolean importFile(File serverFile) {
		
		
		
		
		//use file name to insert into table info table
		//use id from table info to create column info table
		
		//parse column names
		//map to column names model
		//insert column names table with tablenameid relating to id above 
		//get id back of column name table

		
		//parse rows
		//add to list of models
		//insert to column data table with column name id relating to id above
		
		
		//deserialize data?



		
		
		return false;
	}

	
	@Autowired
	public void setImportDAO(IImportDAO importDAO) {
		
		this.importDAO = importDAO;
		
		
	}
	
	
	
}
