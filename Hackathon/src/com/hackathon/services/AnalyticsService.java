package com.hackathon.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.hackathon.model.ColumnDataModel;
import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.CredentialModel;
import com.hackathon.model.RegisterModel;
import com.hackathon.model.SearchModel;
import com.hackathon.model.TableModel;
import com.hackathon.services.business.ITableService;

@RestController
@RequestMapping("/analyticsservice")
public class AnalyticsService 
{
	ITableService tableService;
	
	@Autowired
	public void setTableFormService(ITableService service) {
		this.tableService = service;
	}
	
	
	@RequestMapping("/analyze")
    public String analyzeColumns(@RequestParam(value = "table", required = false) String table, HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session) throws Exception 
	{
		if(session != null && session.getAttribute("admin") != null)
		{
			try
			{
				TableModel tm = new TableModel(0, table);
		        
		        ArrayList<ColumnHeadModel> columnHeaders = new ArrayList<ColumnHeadModel>(tableService.getColumns(tm));
		        
		        ArrayList<ArrayList<ColumnDataModel>> columnData = new ArrayList<ArrayList<ColumnDataModel>>();
		        
		        int numberColumns = tableService.getNumberRows(tm);
		        System.out.print(numberColumns);
		        
		        int i = 1;
		        
		        for(int x = 0; x < numberColumns; x++)
		        {
		        	ArrayList<ColumnDataModel> newList = new ArrayList<ColumnDataModel>();
		        	for(ColumnHeadModel datacolumn : columnHeaders)
		        	{
		        		newList.add(tableService.getColumnData(i, datacolumn.getId(), tm));
		        		i++;
		        	}
		        	columnData.add(newList);
		        }
		        
		        Gson gson1 = new Gson();
		        
		        return gson1.toJson(columnHeaders);
			}
			catch(Exception e)
			{
				System.out.println("Database Exception. Caught in Employee Controller.");
	
				ModelAndView mav = new ModelAndView("secureError");
				
				mav.addObject("search", new SearchModel());

			}
	    }
		else
		{
			ModelAndView mav = new ModelAndView("registerUser");
			
			mav.addObject("login", new CredentialModel());
			mav.addObject("register", new RegisterModel());
			mav.addObject("search", new SearchModel());
			
			return null;
		}
		return null;
    }
	
	
	
	@RequestMapping(value = "/analyzeData", method = RequestMethod.POST)
    public String analyzeData(@RequestParam(value = "table", required = false) String table, @RequestParam(value = "col1", required = false) String col1, HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session) throws Exception 
	{
		if(session != null && session.getAttribute("admin") != null)
		{
			try
			{
				TableModel tm = new TableModel(0, table);
		        
		        int numberRows = tableService.getNumberRows(tm);
		        ArrayList<ColumnHeadModel> columnHeaders = new ArrayList<ColumnHeadModel>(tableService.getColumns(tm));
		        
		        ArrayList<String> col1data = new ArrayList<String>();
		        ArrayList<String> col2data = new ArrayList<String>();
		        
		        int i = 1;
		        int column1 = Integer.parseInt(col1);
		        System.out.println("TEST col1 " + col1);
		        
		        for(int x = 0; x < numberRows; x++)
		        {
			        System.out.println("TEST x " + x);
			        for(ColumnHeadModel colum : columnHeaders)
			        {
	        			if(colum.getId() == column1)
    					{
	        				if(!col1data.contains(tableService.getColumnData(i, column1, tm).getColumnData()))
	        				{
		        				col1data.add(tableService.getColumnData(i, column1, tm).getColumnData());
		        				col2data.add("1");
	        				}
	        				else 
		        			{
		        				int index = col1data.indexOf(tableService.getColumnData(i, column1, tm).getColumnData());
		        				int value = Integer.parseInt(col2data.get(index));
		        				value++;
		        				col2data.set(index, String.valueOf(value));
		        			}
    					}
	        			
	        			i++;
			        }

	        		
		        }
		        System.out.println("TEST HERE");

		        ArrayList<ArrayList<String>> values = new ArrayList<ArrayList<String>>();
		        values.add(col1data);
		        values.add(col2data);
		        
		        Gson gson1 = new Gson();
		        System.out.println(values.toString());
		        return gson1.toJson(values);
			}
			catch(Exception e)
			{
				System.out.println("Database Exception. Caught in Employee Controller.");
	
				ModelAndView mav = new ModelAndView("secureError");
				
				mav.addObject("search", new SearchModel());

			}
	    }
		else
		{
			ModelAndView mav = new ModelAndView("registerUser");
			
			mav.addObject("login", new CredentialModel());
			mav.addObject("register", new RegisterModel());
			mav.addObject("search", new SearchModel());
			
			return null;
		}
		return null;
    }
}
