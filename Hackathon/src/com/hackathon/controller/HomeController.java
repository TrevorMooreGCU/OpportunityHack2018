package com.hackathon.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.hackathon.model.CredentialModel;
import com.hackathon.model.RegisterModel;
import com.hackathon.model.SearchModel;

@Controller
@RequestMapping("/")
public class HomeController 
{	

	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView getSocialNorm(HttpSession session) 
	{
		session.removeAttribute("user");
		session.removeAttribute("admin");

		ModelAndView mav = new ModelAndView("home");
		
		mav.addObject("login", new CredentialModel());
		mav.addObject("search", new SearchModel());

		
		return mav;
	}

	@RequestMapping(path="/Home", method=RequestMethod.GET)
	public ModelAndView getSecureSocialNorm(HttpSession session) 
	{
		if(session != null && session.getAttribute("user") != null)
		{
			ModelAndView mav = new ModelAndView("secureHome");

			mav.addObject("search", new SearchModel());

			return mav;
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
