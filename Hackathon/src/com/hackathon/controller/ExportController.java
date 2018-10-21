package com.hackathon.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.hackathon.model.Book;
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
 
		TableModel table = new TableModel(24, "Dogs");
        String csvFileName = "books.csv";
 
        response.setContentType("text/csv");
 
        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
 
        Book book1 = new Book("Effective Java", "Java Best Practices",
                "Joshua Bloch", "Addision-Wesley", "0321356683", "05/08/2008",
                38);
 
        Book book2 = new Book("Head First Java", "Java for Beginners",
                "Kathy Sierra & Bert Bates", "O'Reilly Media", "0321356683",
                "02/09/2005", 30);
 
        Book book3 = new Book("Thinking in Java", "Java Core In-depth",
                "Bruce Eckel", "Prentice Hall", "0131872486", "02/26/2006", 45);
 
        Book book4 = new Book("Java Generics and Collections",
                "Comprehensive guide to generics and collections",
                "Naftalin & Philip Wadler", "O'Reilly Media", "0596527756",
                "10/24/2006", 27);
 
        List<Book> listBooks = Arrays.asList(book1, book2, book3, book4);
 
        // uses the Super CSV API to generate CSV data from the model data
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
        String[] header = new String[tableService.getNumberColumns(table)];
 
        csvWriter.writeHeader(header);
 
        for (Book aBook : listBooks) {
            csvWriter.write(aBook, header);
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
