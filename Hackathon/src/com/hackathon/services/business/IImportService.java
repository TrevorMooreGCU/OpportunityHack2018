package com.hackathon.services.business;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hackathon.model.ColumnDataModel;
import com.hackathon.services.data.IImportDAO;

public interface IImportService 
{


	public boolean importFile(File file, String table);

	public boolean validTableName(String name);
	
	
	public boolean createInput(List<ColumnDataModel> inputValues, String tableName);
	
	
	
}
