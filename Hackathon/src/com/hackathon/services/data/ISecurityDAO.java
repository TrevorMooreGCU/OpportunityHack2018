package com.hackathon.services.data;

import com.hackathon.model.CredentialModel;
import com.hackathon.model.EmployeeModel;

public interface ISecurityDAO 
{
	public String checkUser(CredentialModel user);
	public boolean checkAdmin(String usersID);
	public EmployeeModel getAdmin(String usersID);
}
