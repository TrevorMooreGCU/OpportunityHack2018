package com.hackathon.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.hackathon.model.CredentialModel;
import com.hackathon.model.RegisterModel;
import com.hackathon.model.SearchModel;
import com.hackathon.services.business.IRegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController 
{
	IRegisterService registerService;

	@Autowired
	public void setRegisterService(IRegisterService service)
	{
		this.registerService = service;
	}

	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView displayRegisterForm()
	{
		ModelAndView mav = new ModelAndView("registerUser");
		
		mav.addObject("login", new CredentialModel());
		mav.addObject("register", new RegisterModel());
		mav.addObject("search", new SearchModel());

		return mav;
	}

	@RequestMapping(path="/registeruser", method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("register") RegisterModel user, BindingResult result)
	{
		if(result.hasErrors())
		{
			ModelAndView mav = new ModelAndView("registerUser");
			
			mav.addObject("login", new CredentialModel());
			mav.addObject("register", user);
			mav.addObject("search", new SearchModel());

			return mav;
		}

		try
		{
			String results = registerService.register(user);

			if(results == "success")
			{
				ModelAndView mav = new ModelAndView("registerSuccess");
				
				mav.addObject("login", new CredentialModel());
				mav.addObject("register", user);
				mav.addObject("search", new SearchModel());
				
				return mav;
			}
			else if(results == "failure")
			{
				ModelAndView mav = new ModelAndView("error");
				
				mav.addObject("login", new CredentialModel());
				mav.addObject("search", new SearchModel());

				return mav;
			}
			else
			{
				ModelAndView mav = new ModelAndView("registerUser");
				
				mav.addObject("login", new CredentialModel());
				mav.addObject("register", user);
				mav.addObject("search", new SearchModel());

				mav.addObject("message", "Username is already taken, please choose another one.");

				return mav;
			}
		}
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Register Controller.");

			ModelAndView mav = new ModelAndView("error");
			
			mav.addObject("login", new CredentialModel());
			mav.addObject("search", new SearchModel());

			return mav;
		}
	}
	

}