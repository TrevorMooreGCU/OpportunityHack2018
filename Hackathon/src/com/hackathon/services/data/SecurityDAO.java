package com.hackathon.services.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.hackathon.model.CredentialModel;
import com.hackathon.model.EmployeeModel;


public class SecurityDAO implements ISecurityDAO
{

	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	@Override
	public String checkUser(CredentialModel user) 
	{
		String query = "SELECT * FROM nod3eke2u33fhtk2.authusers WHERE USERNAME = ? AND PASSWORD = ?";
		String query2 = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE ID = ?";
		
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, user.getUsername(), user.getPassword());
        String uid;
		
        if(!srs.next())
        {
        	return "false";
        }
        else
        	uid = srs.getString("USERSID");
        
		SqlRowSet srs2 = jdbcTemplate.queryForRowSet(query2, uid);
		srs2.next();
        String active = srs2.getString("IS_ACTIVE");
        String term = srs2.getString("IS_TERMINATED");

		System.out.println(active + " term: " + term);
        if(active.equals("0") || term.equals("1"))
        	return "false";
        else
        	return uid;
		
		/*try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			String query = "SELECT * FROM nod3eke2u33fhtk2.authusers WHERE USERNAME = ? AND PASSWORD = ?";
			String query2 = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE ID = ?";
			
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			PreparedStatement pt2 = dbconn.dbConnect().prepareStatement(query2);

			pt.setString(1, user.getUsername());
			pt.setString(2, user.getPassword());

            pt.execute();
            ResultSet rs = pt.getResultSet();
            String uid;
            
            if(!rs.next())
            {
            	pt.close();
            	return "false";
            }
            else
            	uid = rs.getString("USERSID");
            
            pt.close();
            
            pt2.setString(1, uid);
            pt2.execute();
            ResultSet rs2 = pt2.getResultSet();
            rs2.next();
            String active = rs2.getString("IS_ACTIVE");
            String term = rs2.getString("IS_TERMINATED");
            pt2.close();
    		System.out.println(active + " term: " + term);
            if(active.equals("0") || term.equals("1"))
            	return "false";
            else
            	return uid;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in SecurityDAO.");
			return "false";
		}*/
	}
	
	@Override
	public boolean checkAdmin(String usersID) 
	{
		
		
		String query = "SELECT IS_ADMIN FROM nod3eke2u33fhtk2.authemployee WHERE ID = ?";

		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, usersID);
		srs.next();
        if(srs.getInt("IS_ADMIN") == 1)
        	return true;
        else
        	return false;

		/*try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			String query = "SELECT IS_ADMIN FROM nod3eke2u33fhtk2.authemployee WHERE ID = ?";

			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);

			pt.setString(1, usersID);

            pt.execute();
            ResultSet rs = pt.getResultSet();
            rs.next();
            if(rs.getInt("IS_ADMIN") == 1)
            	return true;
            else
            	return false;
            
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in SecurityDAO.");
			return false;
		}*/
	}
	
	@Override
	public EmployeeModel getAdmin(String usersID) 
	{
		
		String query = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE ID = ?";

		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, usersID);
		
       srs.next();
        EmployeeModel em = new EmployeeModel(srs.getString("FIRSTNAME"), srs.getString("LASTNAME"), srs.getString("PHONE"), srs.getString("EMAIL"), srs.getString("EMPLOYEEID"), srs.getString("IS_ADMIN"), srs.getString("IS_ACTIVE"), srs.getString("IS_TERMINATED"));
        return em;
		

		/*try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			String query = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE ID = ?";

			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);

			pt.setString(1, usersID);

            pt.execute();
            ResultSet rs = pt.getResultSet();
            rs.next();
            EmployeeModel em = new EmployeeModel(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("PHONE"), rs.getString("EMAIL"), rs.getString("EMPLOYEEID"), rs.getString("IS_ADMIN"), rs.getString("IS_ACTIVE"), rs.getString("IS_TERMINATED"));
            return em;
            
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in SecurityDAO.");
			return null;
		}*/
	}
	
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
}
