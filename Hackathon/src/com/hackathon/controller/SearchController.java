package com.hackathon.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.hackathon.model.CredentialModel;
import com.hackathon.model.EmployeeListWrapper;
import com.hackathon.model.EmployeeModel;
import com.hackathon.model.RegisterModel;
import com.hackathon.model.SearchModel;
import com.hackathon.services.business.IEmployeeService;

@Controller
@RequestMapping("/search")
public class SearchController 
{
	IEmployeeService employeeService;


	@Autowired
	public void setEmployeeService(IEmployeeService service)
	{
		this.employeeService = service;
	}
	
	@RequestMapping(path="/usersearch", method=RequestMethod.POST)
	public ModelAndView search(@Valid @ModelAttribute("search") SearchModel search, BindingResult result)
	{
		if(result.hasErrors())
		{
			ModelAndView mav = new ModelAndView("searchError");
			
			mav.addObject("login", new CredentialModel());
			mav.addObject("search", search);

			return mav;
		}

		ModelAndView mav = new ModelAndView("home");
		
		mav.addObject("login", new CredentialModel());
		mav.addObject("search", search);

		return mav;
		
	}
	
	@RequestMapping(path="/securesearch", method=RequestMethod.POST)
	public ModelAndView secureSearch(@Valid @ModelAttribute("search") SearchModel search, BindingResult result, HttpSession session)
	{
		if(session != null && session.getAttribute("user") != null)
		{
			if(result.hasErrors())
			{
				ModelAndView mav = new ModelAndView("secureSearchError");

				mav.addObject("search", search);

				return mav;
			}

			ModelAndView mav = new ModelAndView("secureHome");
			
			mav.addObject("search", search);

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
	
	@RequestMapping(path="/secureemployeesearch", method=RequestMethod.POST)
	public ModelAndView secureEmployeeSearch(@Valid @ModelAttribute("search") SearchModel search, BindingResult result, HttpSession session)
	{
		if(session != null && session.getAttribute("admin") != null)
		{
			if(result.hasErrors())
			{
				ModelAndView mav = new ModelAndView("secureSearchError");

				mav.addObject("search", search);

				return mav;
			}
			try
			{
				ModelAndView mav = new ModelAndView("viewEmployees");
				
		        EmployeeListWrapper wrapper = new EmployeeListWrapper();
		
		        wrapper.setEmployees(new ArrayList<EmployeeModel>(employeeService.searchEmployees(search)));
		        
		        String id = (String) session.getAttribute("admin");
	
		        mav.addObject("search", new SearchModel());
		        mav.addObject("esearch", new SearchModel());
		        mav.addObject("wrapper", wrapper);
		        mav.addObject("id", id);
	
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
