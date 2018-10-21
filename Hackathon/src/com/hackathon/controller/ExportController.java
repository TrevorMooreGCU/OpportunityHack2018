package com.hackathon.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import com.hackathon.model.ColumnsModel;
import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.TableModel;
import com.hackathon.services.business.ITableService;

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
    public void downloadCSV(HttpServletResponse response) throws IOException {
 
		TableModel table = new TableModel(29, "dogs");
        String csvFileName = "books.csv";
 
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
        		model.addString(tableService.getColumnData(i, column.getId(), table).getColumnData());
        		i++;
        	}
        	csvWriter.write(model, header);
        }
 
        csvWriter.close();
    }
	
	
	/**
	@RequestMapping(value = "/downloadCSV")
    public void downloadCSV(HttpServletResponse response) throws IOException 
	{
        String csvFileName = "yourfile.csv";
 
        response.setContentType("text/csv");
 
        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
 
        //get table name
        
        //retrieve columns based off table name
        
        //retrieve data based off columns
 
        List<> columnData = Arrays.asList(book1, book2, book3, book4);
 
        // uses the Super CSV API to generate CSV data from the model data
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
        String[] header = { "Title", "Description", "Author", "Publisher",
                "isbn", "PublishedDate", "Price" };
 
        csvWriter.writeHeader(header);
 
        
        for (Book columnData : listBooks) {
            csvWriter.write(aBook, header);
        }
 
        csvWriter.close();
    }
	**/
}
