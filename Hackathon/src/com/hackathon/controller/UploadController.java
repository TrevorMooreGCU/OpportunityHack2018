package com.hackathon.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import com.hackathon.model.TableModel;
import com.hackathon.services.business.IImportService;

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
		if(result.hasErrors())
		{
			ModelAndView mav = new ModelAndView("createTable");
			mav.addObject("table", table);

			return mav;
		}

		session.setAttribute("table" , table.getTableName());
		
		ModelAndView mav = new ModelAndView("csvUpload");
		
		return mav;


	}
	
	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
	public ModelAndView uploadFile(ModelMap model, @RequestParam("file") MultipartFile file, HttpServletRequest request, HttpSession session)
	{
	 
		ModelAndView mav = new ModelAndView("displayData");
		ModelAndView emav = new ModelAndView("secureError");
		String table = (String) session.getAttribute("table");
		
	    if (file.isEmpty()) 
	    {
	    	System.out.println("Database Exception. Caught in Employee Controller.");
			return emav;
	    }
	 
	    String rootPath = request.getSession().getServletContext().getRealPath("/");
	    File dir = new File(rootPath + File.separator + "uploadedfile");
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }
	 
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
	    	return emav;
	    }
	    
	    
	    if(importService.importFile(serverFile, table)) 
	    	return mav;
	    else
	    	return emav;
	    
	    
	 
	    
	}
	
}
