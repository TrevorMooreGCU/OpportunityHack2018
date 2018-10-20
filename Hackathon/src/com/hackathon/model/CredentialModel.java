package com.hackathon.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class CredentialModel
{
	@NotNull(message="Username cannot be left blank.")
	@Size(min=8, max=25, message="Must be between 8 and 25 characters.")
	protected String username;
	
	@NotNull(message="Password cannot be left blank.")
	@Size(min=8, max=25, message="Must be between 8 and 25 characters.")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()]).{8,25})", message="Must contain at least 8 characters, 1 uppercase letter, 1 lowercase letter, 1 number and 1 special character.")
	protected String password;

	public CredentialModel()
	{
		this.username = "";
		this.password = "";
	}
	
	public CredentialModel(String username, String password) 
	{
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
