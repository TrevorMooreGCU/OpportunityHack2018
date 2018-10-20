package com.hackathon.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeModel
{
	@NotNull(message="First Name cannot be left blank.")
	@Size(min=2, max=25, message="Must be between 2 and 25 characters.")
	protected String firstName;
	
	@NotNull(message="Last Name cannot be left blank.")
	@Size(min=2, max=25, message="Must be between 2 and 25 characters.")
	protected String lastName;
	
	@NotNull(message="Email cannot be left blank.")
	@Size(min=7, max=40, message="Must be between 7 and 40 characters.")
	@Pattern(regexp="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="Must be a real email.")
	protected String email;
	
	@NotNull(message="Phone cannot be left blank.")
	@Digits(integer=10, fraction=0, message="Must be a real phone number.")
	protected String phone;
	
	@NotNull(message="Employee ID cannot be left blank.")
	@Digits(integer=6, fraction=0, message="Must be 6 numbers.")
	protected String employeeid;
	
	@NotNull(message="Admin flag cannot be left blank.")
	@Digits(integer=1, fraction=0, message="Must be 1 (for Admin) or 0 (for Employee).")
	protected String admin;
	
	@NotNull(message="Active flag cannot be left blank.")
	@Digits(integer=1, fraction=0, message="Must be 1 (for Active) or 0 (for Inactive).")
	protected String active;
	
	@NotNull(message="Terminated flag cannot be left blank.")
	@Digits(integer=1, fraction=0, message="Must be 1 (for Terminated) or 0 (for Hired/not Terminated).")
	protected String terminated;

	public EmployeeModel()
	{
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.phone = "";
		this.employeeid = "";
		this.admin = "";
		this.active = "";
		this.terminated = "";
	}

	public EmployeeModel(String firstName, String lastName, String email, String phone, String employeeid, String admin, String active, String terminated) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.employeeid = employeeid;
		this.admin = admin;
		this.active = active;
		this.terminated = terminated;
	}

	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getTerminated() {
		return terminated;
	}
	public void setTerminated(String terminated) {
		this.terminated = terminated;
	}
}
