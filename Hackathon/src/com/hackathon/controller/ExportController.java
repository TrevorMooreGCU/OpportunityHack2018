package com.hackathon.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.TableModel;
import com.hackathon.services.business.ITableService;
import com.opencsv.CSVWriter;

@Controller
@RequestMapping("/export")
public class ExportController 
{
	ITableService tableService;
	
	@Autowired
	public void setTableFormService(ITableService service) {
		this.tableService = service;
	}
	
	@RequestMapping(value = "/downloadCSV")
    public void downloadCSV(@RequestParam(value = "file", required = false) String file, HttpServletResponse response) throws IOException
	{
		TableModel table = new TableModel(0, file);

	    File csvFile = new File(file+".csv"); 
	    
	    response.setContentType("text/csv");

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
        		csvFile);
        response.setHeader(headerKey, headerValue);
	    
	    int numberColumns = tableService.getNumberColumns(table);
        
        ArrayList<ColumnHeadModel> columns = new ArrayList<ColumnHeadModel>(tableService.getColumns(table));
        
        int numberRows = tableService.getNumberRows(table);
       
	    
	    try 
	    { 
	    	CSVWriter writer = new CSVWriter(response.getWriter());
	        
	        String[] header = new String[numberColumns];
	        
	        for(int x = 0; x < numberColumns; x++)
	        {
	        	header[x] = columns.get(x).getColumnName();
	        }
	 
	        writer.writeNext(header);
	        int i = 1;
	        for(int x = 0; x < numberRows; x++)
	        {
	        	String[] rowData = new String[numberColumns];
	        	
	        	for(int y = 0; y < numberColumns; y++)
	        	{
	        		rowData[y] = tableService.getColumnData(i, columns.get(y).getId(), table).getColumnData();
	        		i++;
	        	}
	        	writer.writeNext(rowData);
	        }

	        writer.close(); 
	    } 
	    catch (IOException e) { 
	        e.printStackTrace(); 
	    } 
	}
	
}
