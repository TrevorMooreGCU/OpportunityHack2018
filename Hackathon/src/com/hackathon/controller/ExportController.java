package com.hackathon.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import com.hackathon.model.ColumnsModel;
import com.hackathon.model.ColumnDataModel;
import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.TableModel;
import com.hackathon.services.business.ITableService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;

@Controller
@RequestMapping("/export")
public class ExportController 
{
	ITableService tableService;
	
	private static final String COMMA_DELIMITER = ",";
    private static final String LINE_SEPARATOR = "\n";
	
	@Autowired
	public void setTableFormService(ITableService service) {
		this.tableService = service;
	}
	
	
	@RequestMapping(value = "/downloadCSV*")
    public void downloadCSV(@RequestParam(value = "file", required = false) String file, HttpServletResponse response) throws IOException {
 
		TableModel table = new TableModel(0, file);
        String csvFileName = file+".csv";
 
        response.setContentType("text/csv");
 
        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
 
        int numberColumns = tableService.getNumberColumns(table);
        
        ArrayList<ColumnHeadModel> columns = new ArrayList<ColumnHeadModel>(tableService.getColumns(table));
        
        
        
        int numberRows = tableService.getNumberRows(table);
        System.out.print(numberRows);
        
        int i = 1;
        
        
 
        
        
        
        
        // uses the Super CSV API to generate CSV data from the model data
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
        
 
        String[] header = new String[numberColumns];
        
        for(int x = 0; x < numberColumns; x++)
        {
        	header[x] = columns.get(x).getColumnName();
        }
 
        csvWriter.writeHeader(header);
        
        
        
        
        
        for(int x = 0; x < numberRows; x++)
        {
        	ColumnsModel model = new ColumnsModel();
        	for(ColumnHeadModel column : columns)
        	{
        		csvWriter.write(tableService.getColumnData(i, column.getId(), table).getColumnData(), header[i]);
        		i++;
        	}
        	i=0;
        	//csvWriter.write(header, header);
        }
        
        csvWriter.close();
    }
	
	@RequestMapping(value = "/download2")
    public void download2(@RequestParam(value = "file", required = false) String file, HttpServletResponse response) throws IOException
	{
		TableModel table = new TableModel(0, file);
		// first create file object for file placed at location 
	    // specified by filepath 
	    File csvFile = new File(file+".csv"); 
	    
	    response.setContentType("text/csv");
	    
        // creates mock data
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
	        System.out.println(numberColumns + " this is the columns");
	        
	        for(int x = 0; x < numberColumns; x++)
	        {
	        	header[x] = columns.get(x).getColumnName();
	        	System.out.println(header[x] + " these are the headers");
	        }
	 
	        writer.writeNext(header);
	        int i = 1;
	        for(int x = 0; x < numberRows; x++)
	        {
	        	String[] rowData = new String[numberColumns];
	        	
	        	for(int y = 0; y < numberColumns; y++)
	        	{
	        		System.out.println("index: " + y);
	        		System.out.println("ID " + i + ", columnID: " + y);
	        		System.out.println(tableService.getColumnData(i, columns.get(y).getId(), table).getColumnData());
	        		rowData[y] = tableService.getColumnData(i, columns.get(y).getId(), table).getColumnData();
	        		i++;
	        	}
	        	writer.writeNext(rowData);
	        }

	  
	        // closing writer connection 
	        writer.close(); 
	    } 
	    catch (IOException e) { 
	        // TODO Auto-generated catch block 
	        e.printStackTrace(); 
	    } 
	}
	
	
	
	@RequestMapping(value = "/download")
    public void download(@RequestParam(value = "file", required = false) String file, HttpServletResponse response) throws IOException
	{
		TableModel table = new TableModel(0, file);
        String csvFileName = file+".csv";
 
        response.setContentType("text/csv");
        
		int numberColumns = tableService.getNumberColumns(table);
        
        ArrayList<ColumnHeadModel> columns = new ArrayList<ColumnHeadModel>(tableService.getColumns(table));
        
        ArrayList<ArrayList<ColumnDataModel>> columnData = new ArrayList<ArrayList<ColumnDataModel>>();
        
        int numberRows = tableService.getNumberRows(table);
        System.out.print(numberColumns);
        
        int i = 1;
        
        for(int x = 0; x < numberRows; x++)
        {
        	ArrayList<ColumnDataModel> newList = new ArrayList<ColumnDataModel>();
        	for(ColumnHeadModel datacolumn : columns)
        	{
        		newList.add(tableService.getColumnData(i, datacolumn.getId(), table));
        		i++;
        	}
        	columnData.add(newList);
        }
		
		FileWriter fileWriter = null;
		
		try
		{
			fileWriter = new FileWriter(csvFileName);

			for(int x = 0; x < numberColumns; x++)
			{
				fileWriter.append(columns.get(x).getColumnName());
				System.out.println(columns.get(x).getColumnName());
				fileWriter.append(COMMA_DELIMITER);
			}
			fileWriter.append(LINE_SEPARATOR);
			
			for(int y = 0; y < numberRows; y++)
			{
				for(int x = 0; x < numberColumns; x++)
				{
					fileWriter.append(columnData.get(y).get(x).getColumnData());
					System.out.println(columnData.get(y).get(x).getColumnData());
					fileWriter.append(COMMA_DELIMITER);
				}
				fileWriter.append(LINE_SEPARATOR);
			}

			System.out.println("Write to CSV file Succeeded!!!");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		finally
		{
			try
			{
				fileWriter.flush();
				fileWriter.close();
			}
			catch(IOException ie)
			{
				System.out.println("Error occured while closing the fileWriter");
		  			ie.printStackTrace();
		  	}
		}
	}
	
}
