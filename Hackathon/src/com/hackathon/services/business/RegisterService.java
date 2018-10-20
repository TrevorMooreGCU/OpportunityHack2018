package com.hackathon.services.business;

import org.springframework.beans.factory.annotation.Autowired;
import com.hackathon.model.RegisterModel;
import com.hackathon.services.data.IRegistrationDAO;

public class RegisterService implements IRegisterService
{
	IRegistrationDAO registrationDAO;

	@Autowired
	public void setRegistrationDAO(IRegistrationDAO dao)
	{
		this.registrationDAO = dao;
	}

	@Override
	public String register(RegisterModel user) 
	{
		try
		{
			return registrationDAO.registerUser(user);
		}
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Register Service.");
			return "failure";
		}
	}
}
