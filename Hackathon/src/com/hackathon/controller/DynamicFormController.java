package com.hackathon.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hackathon.model.ColumnDataModel;
import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.CredentialModel;
import com.hackathon.model.EmployeeListWrapper;
import com.hackathon.model.EmployeeModel;
import com.hackathon.model.RegisterModel;
import com.hackathon.model.SearchModel;
import com.hackathon.model.TableModel;
import com.hackathon.services.business.ITableService;

@Controller
@RequestMapping("/dynamic")
public class DynamicFormController {
	
	ITableService tableService;
	
	@Autowired
	public void setTableFormService(ITableService service) {
		this.tableService = service;
	}
	
	
	@RequestMapping(path="/headers", method=RequestMethod.GET)
	public ModelAndView getDynamicForm(HttpSession session) {
		
		if(session != null && session.getAttribute("admin") != null)
		{
			try
			{
		        ModelAndView mav = new ModelAndView("viewDynamicForm");
		        
		        ArrayList<ColumnHeadModel> columnHeaders = new ArrayList<ColumnHeadModel>(tableService.tableForm(table));
		
		        mav.addObject("tableTitle", new TableModel());
		        mav.addObject("columnHeaders", columnHeaders);
	
		        return mav;
			}
			catch(Exception e)
			{
				System.out.println("Database Exception. Caught in Employee Controller.");
	
				ModelAndView mav = new ModelAndView("secureError");
				
				mav.addObject("search", new SearchModel());
	
				return mav;
			}
	    }
		else
		{
			ModelAndView mav = new ModelAndView("registerUser");
			
			mav.addObject("login", new CredentialModel());
			mav.addObject("register", new RegisterModel());
			mav.addObject("search", new SearchModel());
			
			return mav;
		}
		
	}
	
	
	
	
	
	
	@RequestMapping(path="/getdataset", method=RequestMethod.GET)
	public ModelAndView getDataSet(HttpSession session) {
		
		if(session != null && session.getAttribute("admin") != null)
		{
			try
			{
				TableModel table = new TableModel(29, "dogs");
		        ModelAndView mav = new ModelAndView("displayData");
		        
		        ArrayList<ColumnHeadModel> columnHeaders = new ArrayList<ColumnHeadModel>(tableService.getColumns(table));
		        
		        ArrayList<ArrayList<ColumnDataModel>> columnData = new ArrayList<ArrayList<ColumnDataModel>>();
		        
		        int numberColumns = tableService.getNumberColumns(table);
		        System.out.print(numberColumns);
		        
		        int i = 1;
		        
		        for(int x = 0; x < numberColumns; x++)
		        {
		        	ArrayList<ColumnDataModel> newList = new ArrayList<ColumnDataModel>();
		        	for(ColumnHeadModel datacolumn : columnHeaders)
		        	{
		        		newList.add(tableService.getColumnData(i, datacolumn.getId(), table));
		        		i++;
		        	}
		        	columnData.add(newList);
		        }
		
		        mav.addObject("tableTitle", table);
		        mav.addObject("columns", columnHeaders);
		        mav.addObject("datacolumns", columnData);
	
		        return mav;
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
			}
			catch(Exception e)
			{
				System.out.println("Database Exception. Caught in Employee Controller.");
	
				ModelAndView mav = new ModelAndView("secureError");
				
				mav.addObject("search", new SearchModel());
	
				return mav;
			}
	    }
		else
		{
			ModelAndView mav = new ModelAndView("registerUser");
			
			mav.addObject("login", new CredentialModel());
			mav.addObject("register", new RegisterModel());
			mav.addObject("search", new SearchModel());
			
			return mav;
		}
		
	}

}
