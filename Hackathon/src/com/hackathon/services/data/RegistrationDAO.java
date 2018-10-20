package com.hackathon.services.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.hackathon.model.RegisterModel;

public class RegistrationDAO implements IRegistrationDAO
{
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	

	@Override
	public String registerUser(RegisterModel user) 
	{
		
		// for checking if a user is a real employee
		String query1 = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE FIRSTNAME = ? AND LASTNAME = ? AND EMPLOYEEID = ?";
		// for checking if a username is already in the database
		String query2 = "SELECT * FROM nod3eke2u33fhtk2.authusers WHERE USERNAME = ?";
		// for inserting the new username and password into the users table
		String query3 = "INSERT INTO nod3eke2u33fhtk2.authusers (USERSID, USERNAME, PASSWORD) VALUES(?, ?, ?)";
		
		SqlRowSet srs1 = jdbcTemplate.queryForRowSet(query1, user.getFirstName(), user.getLastName(), user.getEmployeeid());		
				
        int result;

		
        if(srs1.next())
        {
        	
        	String employeeID = srs1.getString("ID");
        	
    		SqlRowSet srs2 = jdbcTemplate.queryForRowSet(query2, user.getUsername());		
			
            if(!srs2.next())
            {
        		result = jdbcTemplate.update(query3, employeeID, 
        				user.getUsername(), 
        				user.getPassword());
            }
            else
            	return "duplicate";
            
            
            if(result > 0)
            {
				System.out.println("Registration Successful.");
				return "success";
			}
            else
            {
            	System.out.println("authusers insert failed.");
            	return "failure";
            }

        } else
        	return "failure";
		
		/*try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			// for checking if a user is a real employee
			String query1 = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE FIRSTNAME = ? AND LASTNAME = ? AND EMPLOYEEID = ?";
			// for checking if a username is already in the database
			String query2 = "SELECT * FROM nod3eke2u33fhtk2.authusers WHERE USERNAME = ?";
			// for inserting the new username and password into the users table
			String query3 = "INSERT INTO nod3eke2u33fhtk2.authusers (USERSID, USERNAME, PASSWORD) VALUES(?, ?, ?)";
			
			PreparedStatement pt1 = dbconn.dbConnect().prepareStatement(query1);
			PreparedStatement pt2 = dbconn.dbConnect().prepareStatement(query2);
			PreparedStatement pt3 = dbconn.dbConnect().prepareStatement(query3);
			
			pt1.setString(1, user.getFirstName());
			pt1.setString(2, user.getLastName());
			pt1.setString(3, user.getEmployeeid());
			
			pt2.setString(1, user.getUsername());

			pt1.execute();
            ResultSet rs1 = pt1.getResultSet();
            
            int result;

            if(rs1.next())
            {
            	String employeeID = rs1.getString("ID");
            	pt1.close();
            	
            	pt2.execute();
                ResultSet rs2 = pt2.getResultSet();

                if(!rs2.next())
                {
                	pt2.close();
                	
        			pt3.setString(1, employeeID);
        			pt3.setString(2, user.getUsername());
        			pt3.setString(3, user.getPassword());
                	
                	result = pt3.executeUpdate();
                	pt3.close();
                }
                else
                	return "duplicate";
                
                
                if(result > 0)
                {
    				System.out.println("Registration Successful.");
    				return "success";
    			}
                else
                {
                	System.out.println("authusers insert failed.");
                	return "failure";
                }

            }
            else
            	return "failure";
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in RegistrationDAO.");
			return "failure";
		}*/
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
