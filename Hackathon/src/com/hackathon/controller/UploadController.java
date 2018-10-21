package com.hackathon.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.hackathon.model.ColumnDataModel;
import com.hackathon.model.ColumnHeadModel;
import com.hackathon.model.SearchModel;
import com.hackathon.model.TableModel;
import com.hackathon.services.business.IImportService;
import com.hackathon.services.business.ITableService;

@Controller
@RequestMapping("/upload")
public class UploadController 
{
	IImportService importService;
	
	@Autowired
	public void setImportService(IImportService service)
	{
		this.importService = service;
	}
	
	ITableService tableService;
	
	@Autowired
	public void setTableFormService(ITableService service) {
		this.tableService = service;
	}

	@RequestMapping(path="/uploadcsv", method=RequestMethod.GET)
	public ModelAndView displayCSVUpload()
	{
		ModelAndView mav = new ModelAndView("csvUpload");

		return mav;
	}
	
	@RequestMapping(path="/uploadtable", method=RequestMethod.GET)
	public ModelAndView displayTableUpload()
	{
		ModelAndView mav = new ModelAndView("createTable");
		mav.addObject("table", new TableModel());

		return mav;
	}
	
	@RequestMapping(path="/adddataset", method=RequestMethod.POST)
	public ModelAndView createTable(@Valid @ModelAttribute("table") TableModel table, BindingResult result, HttpSession session)
	{
		if(result.hasErrors() || !importService.validTableName(table.tableName))
		{
			ModelAndView mav = new ModelAndView("createTable");
			mav.addObject("table", table);
			mav.addObject("message", "Table name is either taken, contains spaces, contains non alpha-numeric characters, or a sql reserved keyword.");

			return mav;
		}
		
		

		session.setAttribute("table" , table);
		
		ModelAndView mav = new ModelAndView("csvUpload");
		
		return mav;


	}
	
	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
	public ModelAndView uploadFile(ModelMap model, @RequestParam("file") MultipartFile file, HttpServletRequest request, HttpSession session)
	{
		ModelAndView errmav = new ModelAndView("csvUpload");
		TableModel table = (TableModel) session.getAttribute("table");
		
	    if (file.isEmpty() || !importService.validTableName(table.tableName)) 
	    {
	    	System.out.println("Database Exception. Caught in Employee Controller.");
	    	errmav.addObject("message", "Invalid file, cannot be empty");

	    	

			return errmav;
	    }
	 
	    String rootPath = request.getSession().getServletContext().getRealPath("/");
	    File dir = new File(rootPath + File.separator + "uploadedfile");
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }
	    System.out.println(dir.getAbsolutePath());
	 
	    File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
	    
	    try {
	        try (InputStream is = file.getInputStream();
	                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
	            int i;
	            //write file to server
	            while ((i = is.read()) != -1) {
	                stream.write(i);
	            }
	            stream.flush();
	        }
	    } catch (IOException e) {
	    	return errmav;
	    }
	    
	    
	    if(importService.importFile(serverFile, table.getTableName())) 
	    {
	    	try
			{
		        ModelAndView mav = new ModelAndView("displayData");
		        
		        ArrayList<ColumnHeadModel> columnHeaders = new ArrayList<ColumnHeadModel>(tableService.getColumns(table));
		        
		        ArrayList<ArrayList<ColumnDataModel>> columnData = new ArrayList<ArrayList<ColumnDataModel>>();
		        
		        int numberColumns = tableService.getNumberRows(table);
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
				System.out.println("Database Exception. Caught in Upload Controller.");
	
				ModelAndView mav = new ModelAndView("secureError");
				
				mav.addObject("search", new SearchModel());
	
				return mav;
			}
	    }
	    else
	    {
	    	ModelAndView emav = new ModelAndView("secureError");
	    	return emav;
	    }

	}
	
}
