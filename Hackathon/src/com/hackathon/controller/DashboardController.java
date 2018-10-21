package com.hackathon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hackathon.services.business.ILoginService;
import com.hackathon.services.business.ITableNameService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	ITableNameService tableNameService;

	@Autowired
	public void setLoginService(ITableNameService service)
	{
		this.tableNameService = service;
	}

	@RequestMapping(value = "/main")
	public ModelAndView mainView(HttpSession session) {
		
		if(session != null && session.getAttribute("admin") != null) {
			
			ModelAndView mav = new ModelAndView("userDashboard");
			mav.addObject("tableNames",tableNameService.getTableNames());
			
			return mav;
			
			
		}
		
	}
	
}
