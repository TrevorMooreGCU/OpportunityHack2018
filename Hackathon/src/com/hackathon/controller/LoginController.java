package com.hackathon.controller;

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
import com.hackathon.model.SearchModel;
import com.hackathon.services.business.ILoginService;

@Controller
@RequestMapping("/login")
public class LoginController 
{
	ILoginService loginService;

	@Autowired
	public void setLoginService(ILoginService service)
	{
		this.loginService = service;
	}

	@RequestMapping(path="/loginuser", method=RequestMethod.POST)
	public ModelAndView loginUser(@Valid @ModelAttribute("login") CredentialModel user, BindingResult result, HttpSession session)
	{
		if(result.hasErrors())
		{

			ModelAndView mav = new ModelAndView("loginUser");
			
			mav.addObject("login", user);
			mav.addObject("search", new SearchModel());

			return mav;
		}
		
		try
		{
			String usersID = loginService.loginCheck(user);

			if(usersID != "false")
			{
				ModelAndView mav = new ModelAndView("welcomeHome");
				
				mav.addObject("login", user);
				mav.addObject("search", new SearchModel());

				session.setAttribute("user" , user);

				if(loginService.checkAdmin(usersID))
				{
					String empID = loginService.getAdmin(usersID).getEmployeeid();
					System.out.println(empID);
					session.setAttribute("admin", empID);
				}
				return mav;
			}
			else
			{
				ModelAndView mav = new ModelAndView("loginUser");
				
				mav.addObject("login", user);
				mav.addObject("search", new SearchModel());
				
				mav.addObject("message", "Username or Password was incorrect.");
				
				return mav;
			}
		}
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Login Controller.");
			
			ModelAndView mav = new ModelAndView("error");
			
			mav.addObject("login", new CredentialModel());
			mav.addObject("search", new SearchModel());

			return mav;
		}
	}

}
