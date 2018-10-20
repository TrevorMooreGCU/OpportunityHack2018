





package com.hackathon.services.business;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import com.hackathon.model.CredentialModel;
import com.hackathon.model.EmployeeModel;
import com.hackathon.services.data.IImportDAO;
import com.hackathon.services.data.ISecurityDAO;
import com.opencsv.CSVReader;

public class ImportService implements IImportService
{

	IImportDAO importDAO;
	
	
	@Override
	public boolean importFile(File file) {
		
		
		//deserialize data?
		
		//use file name to insert into table info table
		//use id from table info to create column info table
		
		//parse column names
		//map to column names model
		//insert column names table with tablenameid relating to id above 
		//get id back of column name table

		
		//parse rows
		//add to list of models
		//insert to column data table with column name id relating to id above
		
	
		
		
		
		
		
		return false;
	}

	
	@Autowired
	public void setImportDAO(IImportDAO importDAO) {
		
		this.importDAO = importDAO;
		
		
	}
	
	
	
}
