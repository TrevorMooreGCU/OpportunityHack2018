package com.hackathon.services.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.hackathon.model.EmployeeModel;
import com.hackathon.model.SearchModel;
import com.hackathon.services.data.IEmployeeDAO;

public class EmployeeService implements IEmployeeService
{
	IEmployeeDAO employeeDAO;

	@Autowired
	public void setEmployeeDAO(IEmployeeDAO dao)
	{
		this.employeeDAO = dao;
	}

	@Override
	public boolean addEmployee(EmployeeModel employee) 
	{
		try
		{
			return employeeDAO.addEmployee(employee);
		}
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Employee Service.");
			return false;
		}
	}

	@Override
	public EmployeeModel getEmployee(String employeeID)
	{
		try
		{
			return employeeDAO.getEmployee(employeeID);
		}
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Employee Service.");
			return null;
		}
	}
	
	@Override
	public List<EmployeeModel> getEmployees() 
	{
		try
		{
			return employeeDAO.getEmployees();
		}
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Employee Service.");
			return null;
		}
	}
	
	@Override
	public List<EmployeeModel> searchEmployees(SearchModel search) 
	{
		try
		{
			return employeeDAO.searchEmployees(search);
		}
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Employee Service.");
			return null;
		}
	}

	@Override
	public boolean updateEmployees(List<EmployeeModel> employees) 
	{
		try
		{
			return employeeDAO.updateEmployees(employees);
		}
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Employee Service.");
			return false;
		}
	}
	
	@Override
	public boolean deleteEmployee(String employeeID) 
	{
		try
		{
			return employeeDAO.deleteEmployee(employeeID);
		}
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Employee Service.");
			return false;
		}
	}
}
