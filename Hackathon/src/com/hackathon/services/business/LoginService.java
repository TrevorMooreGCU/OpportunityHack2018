package com.hackathon.services.business;

import org.springframework.beans.factory.annotation.Autowired;
import com.hackathon.model.CredentialModel;
import com.hackathon.model.EmployeeModel;
import com.hackathon.services.data.ISecurityDAO;

public class LoginService implements ILoginService
{
	ISecurityDAO securityDAO;

	@Autowired
	public void setSecurityDAO(ISecurityDAO dao)
	{
		this.securityDAO = dao;
	}

	@Override
	public String loginCheck(CredentialModel user) 
	{
		try
		{
			return securityDAO.checkUser(user);
		}
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Login Service.");
			return "false";
		}
	}

	@Override
	public boolean checkAdmin(String userID) 
	{
		try
		{
			return securityDAO.checkAdmin(userID);
		}
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Login Service.");
			return false;
		}
	}

	@Override
	public EmployeeModel getAdmin(String usersID) 
	{
		try
		{
			return securityDAO.getAdmin(usersID);
		}
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Login Service.");
			return null;
		}
	}
	
}
