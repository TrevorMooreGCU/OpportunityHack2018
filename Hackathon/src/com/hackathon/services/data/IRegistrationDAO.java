package com.hackathon.services.data;

import com.hackathon.model.RegisterModel;

public interface IRegistrationDAO 
{
	public String registerUser(RegisterModel user);
}
