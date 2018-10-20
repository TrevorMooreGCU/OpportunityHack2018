package com.hackathon.services.business;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.hackathon.services.data.IImportDAO;

public interface IImportService 
{


	public boolean importFile(File file);

	
	
	
}
