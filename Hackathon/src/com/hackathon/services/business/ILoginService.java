package com.hackathon.services.business;

import com.hackathon.model.CredentialModel;
import com.hackathon.model.EmployeeModel;

public interface ILoginService
{
	public String loginCheck(CredentialModel user);
	public boolean checkAdmin(String userID);
	public EmployeeModel getAdmin(String usersID);
}
