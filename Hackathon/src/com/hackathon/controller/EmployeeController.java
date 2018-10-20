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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hackathon.model.CredentialModel;
import com.hackathon.model.EmployeeListWrapper;
import com.hackathon.model.EmployeeModel;
import com.hackathon.model.RegisterModel;
import com.hackathon.model.SearchModel;
import com.hackathon.services.business.IEmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController 
{
	
	IEmployeeService employeeService;


	@Autowired
	public void setEmployeeService(IEmployeeService service)
	{
		this.employeeService = service;
	}

	@RequestMapping(path="/employees", method=RequestMethod.GET)
    public ModelAndView getEmployeesView(HttpSession session) 
    {
		if(session != null && session.getAttribute("admin") != null)
		{
			try
			{
		        ModelAndView mav = new ModelAndView("viewEmployees");
		
		        EmployeeListWrapper wrapper = new EmployeeListWrapper();
		
		        wrapper.setEmployees(new ArrayList<EmployeeModel>(employeeService.getEmployees()));
		        
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
	
	@RequestMapping(path="/addemployee", method=RequestMethod.GET)
	public ModelAndView getAddEmployeeView(HttpSession session) 
	{
		if(session != null && session.getAttribute("admin") != null)
		{
			ModelAndView mav = new ModelAndView("addEmployee");
			
			mav.addObject("search", new SearchModel());
			mav.addObject("employee", new EmployeeModel());
			
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

	@RequestMapping(path="/addemployee", method=RequestMethod.POST)
	public ModelAndView addEmployee(@Valid @ModelAttribute("employee") EmployeeModel employee, BindingResult result, HttpSession session)
	{
		if(session != null && session.getAttribute("admin") != null)
		{
			// USE THIS TO GET OBJECTS IN THE SESSION:
			// (CredentialModel) session.getAttribute("user")

			if(result.hasErrors())
			{
				ModelAndView mav = new ModelAndView("addEmployee");
				
				mav.addObject("search", new SearchModel());
				mav.addObject("employee", employee);
				
				return mav;
			}
			
			try
			{
				if(employeeService.addEmployee(employee))
				{
			        ModelAndView mav = new ModelAndView("viewEmployees");
	
			        EmployeeListWrapper wrapper = new EmployeeListWrapper();
	
			        wrapper.setEmployees(new ArrayList<EmployeeModel>(employeeService.getEmployees()));
			        
			        String id = (String) session.getAttribute("admin");
	
			        mav.addObject("search", new SearchModel());
			        mav.addObject("esearch", new SearchModel());
			        mav.addObject("wrapper", wrapper);
			        mav.addObject("id", id);

			        return mav;
				}
				else
				{
					ModelAndView mav = new ModelAndView("secureError");
					
					mav.addObject("search", new SearchModel());
	
					return mav;
				}
				
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
	
	@RequestMapping(path="/updateemployee", method=RequestMethod.POST)
	public ModelAndView updateEmployee(EmployeeListWrapper employees, HttpSession session)
	{
		if(session != null && session.getAttribute("admin") != null)
		{
			// USE THIS TO GET OBJECTS IN THE SESSION:
			// (CredentialModel) session.getAttribute("user")
	
			try
			{
				if(employeeService.updateEmployees(employees.getEmployees()))
				{
			        ModelAndView mav = new ModelAndView("viewEmployees");
	
			        EmployeeListWrapper wrapper = new EmployeeListWrapper();
	
			        wrapper.setEmployees(new ArrayList<EmployeeModel>(employeeService.getEmployees()));
			        
			        String id = (String) session.getAttribute("admin");

			        mav.addObject("search", new SearchModel());
			        mav.addObject("esearch", new SearchModel());
			        mav.addObject("wrapper", wrapper);
			        mav.addObject("id", id);
	
			        return mav;
				}
				else
				{
					ModelAndView mav = new ModelAndView("secureError");
					
					mav.addObject("search", new SearchModel());

					return mav;
				}
				
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
	
	@RequestMapping(path="/remove*", method=RequestMethod.GET)
	public ModelAndView removeEmployee(@RequestParam(value = "id", required = false) String id, HttpSession session)
	{
		if(session != null && session.getAttribute("admin") != null)
		{
			try
			{
				ModelAndView mav = new ModelAndView("removeEmployee");
				System.out.println(id);
				
				mav.addObject("search", new SearchModel());
				mav.addObject("employee", employeeService.getEmployee(id));
				
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
	
	@RequestMapping(path="/deleteemployee", method=RequestMethod.POST)
	public ModelAndView deleteEmployee(EmployeeModel employee, HttpSession session)
	{
		if(session != null && session.getAttribute("admin") != null)
		{
			try
			{
				if(employeeService.deleteEmployee(employee.getEmployeeid()))
				{
			        ModelAndView mav = new ModelAndView("viewEmployees");
	
			        EmployeeListWrapper wrapper = new EmployeeListWrapper();
	
			        wrapper.setEmployees(new ArrayList<EmployeeModel>(employeeService.getEmployees()));
			        
			        String id = (String) session.getAttribute("admin");

			        mav.addObject("search", new SearchModel());
			        mav.addObject("esearch", new SearchModel());
			        mav.addObject("wrapper", wrapper);
			        mav.addObject("id", id);

			        return mav;
				}
				else
				{
					ModelAndView mav = new ModelAndView("secureError");
					
					mav.addObject("search", new SearchModel());

					return mav;
				}
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
