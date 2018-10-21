package com.hackathon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@RequestMapping(value = "/main")
	public ModelAndView mainView(HttpSession session) {
		
		if(session != null && session.getAttribute("admin") != null) {
			
			
			
		}
		
	}
	
}
