





package com.hackathon.services.business;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.hackathon.helpers.ParseHelper;
import com.hackathon.model.ColumnDataModel;
import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.CredentialModel;
import com.hackathon.model.EmployeeModel;
import com.hackathon.services.data.IImportDAO;
import com.hackathon.services.data.ISecurityDAO;
import com.opencsv.CSVReader;

public class ImportService implements IImportService
{

	IImportDAO importDAO;
	
	
	@Override
	public boolean importFile(File file, String table) {
		

		//use file name to insert into table info table
		//use id from table info to create column info table
		
		//parse column names
		//map to column names model
		//insert column names table with tablenameid relating to id above 
		//get id back of column name table

		
		//parse rows
		//add to list of models
		//insert to column data table with column name id relating to id above
		
		
		
		
		List<String[]> rawRows;
		
		try {
		
			rawRows = ParseHelper.parseFile(file);
		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		//use file name to insert into table info table
		//use id from table info to create column info table
		
		int tableNameId = importDAO.insertTableName(table);
		
		if (tableNameId > -1) {

			List<ColumnHeadModel> columnHeadModels = new ArrayList<ColumnHeadModel>();
			

			
			for(String value : rawRows.get(0)) {	
				columnHeadModels.add(new ColumnHeadModel(0, tableNameId, value));
			}
			
			
			if (importDAO.insertColumnNames(columnHeadModels, table)) {
				
				rawRows.remove(0);
				List<ColumnDataModel> columnDataModels = new ArrayList<ColumnDataModel>();
				
				for(String[] rawRowList : rawRows) {
					int index = 1;
					
					for(String value : rawRowList) {	
						columnDataModels.add(new ColumnDataModel(0, tableNameId, index, value));
						index++;
					}
				}
				
				if (importDAO.insertColumnData(columnDataModels, table)) {
					return true;
				}
	
			}

		}
		

		return false;
	}

	@Autowired
	public void setImportDAO(IImportDAO importDAO) {
		
		this.importDAO = importDAO;
		
		
	}

	@Override
	public boolean validTableName(String name) {
		
		//check for spaces, check for reserved words, check for alphabetical or numbers
		
		boolean hasSpaces = name.contains(" ");

		if (!hasSpaces) {
			String regex = "^[a-zA-Z0-9]+$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(name);
			
			boolean hasInvalidCharacters = !matcher.matches();
			
			if (!hasInvalidCharacters) {
				boolean hasKeywords = importDAO.containsReservedWord(name);
				
				if (!hasKeywords) {
					boolean tableNameExists = importDAO.tableNameExists(name);
					
					if (!tableNameExists) {
						return true;
					}

				}
			}
		}
		return false;
	}

	
}
