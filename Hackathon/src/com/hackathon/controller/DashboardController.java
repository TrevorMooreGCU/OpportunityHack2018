package com.hackathon.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hackathon.model.TableModel;
import com.hackathon.services.business.ILoginService;
import com.hackathon.services.business.ITableNameService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	ITableNameService tableNameService;

	@Autowired
	public void setTableNameService(ITableNameService service)
	{
		this.tableNameService = service;
	}

	@RequestMapping(value = "/main")
	public ModelAndView mainView(HttpSession session) {
		
		if(session != null && session.getAttribute("admin") != null) {
			
			ArrayList<TableModel> tables = new ArrayList<TableModel>(tableNameService.getTableNames());
			
			System.out.println("Table names " + tables.size());
			
			ModelAndView mav = new ModelAndView("userDashboard");
			mav.addObject("tableNames",tables);
			
			return mav;
			
			
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
