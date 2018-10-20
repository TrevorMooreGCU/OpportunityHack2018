package com.hackathon.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
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

	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView displayCSVUpload()
	{
		ModelAndView mav = new ModelAndView("csvUpload");

		return mav;
	}
	
	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
	public ModelAndView uploadFile(
	        ModelMap model,
	        @RequestParam MultipartFile file,
	        HttpServletRequest request) 
	{
	 
		ModelAndView mav = new ModelAndView("displayData");
		ModelAndView emav = new ModelAndView("secureError");
		
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
	    
	    
	    if(importService.importFile(serverFile)) 
	    	return mav;
	    else
	    	return emav;
	    
	    
	 
	    
	}
	
}
