package com.hackathon.services.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.hackathon.model.EmployeeModel;
import com.hackathon.model.SearchModel;

public class EmployeeDAO implements IEmployeeDAO
{
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean addEmployee(EmployeeModel employee) 
	{
		
		String query = "INSERT INTO nod3eke2u33fhtk2.authemployee (FIRSTNAME, LASTNAME, PHONE, EMAIL, EMPLOYEEID, IS_ADMIN, IS_ACTIVE, IS_TERMINATED) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		/*SqlRowSet srs = jdbcTemplate.query(query, employee.getFirstName(), 
				employee.getLastName(), 
				employee.getPhone(), 
				employee.getEmail(),
				employee.getEmployeeid(),
				employee.getAdmin(),
				employee.getActive(),
				employee.getTerminated());
		
		int result = srs.exe*/
		
		
		int result = jdbcTemplate.update(query, employee.getFirstName(), 
				employee.getLastName(), 
				employee.getPhone(), 
				employee.getEmail(),
				employee.getEmployeeid(),
				employee.getAdmin(),
				employee.getActive(),
				employee.getTerminated());
		
		System.out.println("insert result: "+result);
		
		return (result > 0);
		/*
		try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			String query = "INSERT INTO nod3eke2u33fhtk2.authemployee (FIRSTNAME, LASTNAME, PHONE, EMAIL, EMPLOYEEID, IS_ADMIN, IS_ACTIVE, IS_TERMINATED) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			System.out.println("Admin:" + employee.getAdmin() + " Active:" + employee.getActive() + " Term:" + employee.getTerminated());

			pt.setString(1, employee.getFirstName());
			pt.setString(2, employee.getLastName());
			pt.setString(3, employee.getPhone());
			pt.setString(4, employee.getEmail());
			pt.setString(5, employee.getEmployeeid());
			pt.setString(6, employee.getAdmin());
			pt.setString(7, employee.getActive());
			pt.setString(8, employee.getTerminated());
			
            int result = pt.executeUpdate();

            pt.close();
            
            return (result > 0);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in EmployeeDAO.");
			return false;
		}*/
		
	}
	
	@Override
	public EmployeeModel getEmployee(String employeeID) 
	{
		
		String query = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE EMPLOYEEID = ?";

		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, employeeID);
		
		srs.next();
		EmployeeModel employee = new EmployeeModel(srs.getString("FIRSTNAME"), srs.getString("LASTNAME"), srs.getString("EMAIL"), srs.getString("PHONE"), srs.getString("EMPLOYEEID"), srs.getString("IS_ADMIN"), srs.getString("IS_ACTIVE"), srs.getString("IS_TERMINATED"));


		/*
		try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			String query = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE EMPLOYEEID = ?";

			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			pt.setString(1, employeeID);

			pt.execute();
			ResultSet rs = pt.getResultSet();
			rs.next();
			EmployeeModel employee = new EmployeeModel(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("EMPLOYEEID"), rs.getString("IS_ADMIN"), rs.getString("IS_ACTIVE"), rs.getString("IS_TERMINATED"));

        	pt.close();

            return employee;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in EmployeeDAO.");
			return null;
		}*/
		return employee;
		
		
		
		
	}
	
	@Override
	public List<EmployeeModel> getEmployees() 
	{
		
		
		String query = "SELECT * FROM nod3eke2u33fhtk2.authemployee";

		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);

		List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
		
		while(srs.next())
		{
			EmployeeModel employee = new EmployeeModel(srs.getString("FIRSTNAME"), srs.getString("LASTNAME"), srs.getString("EMAIL"), srs.getString("PHONE"), srs.getString("EMPLOYEEID"), srs.getString("IS_ADMIN"), srs.getString("IS_ACTIVE"), srs.getString("IS_TERMINATED"));
			employees.add(employee);
		}
		
		return employees;
		/*try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			String query = "SELECT * FROM nod3eke2u33fhtk2.authemployee";
			
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			pt.execute();
			ResultSet rs = pt.getResultSet();
			
			List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
			
			while(rs.next())
			{
				EmployeeModel employee = new EmployeeModel(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("EMPLOYEEID"), rs.getString("IS_ADMIN"), rs.getString("IS_ACTIVE"), rs.getString("IS_TERMINATED"));
				employees.add(employee);
			}

        	pt.close();

            return employees;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in EmployeeDAO.");
			return null;
		}*/
	}
	
	@Override
	public List<EmployeeModel> searchEmployees(SearchModel search) 
	{
		
		
		String query = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE UPPER(FIRSTNAME) LIKE ? OR UPPER(LASTNAME) LIKE ? OR UPPER(EMPLOYEEID) LIKE ?";
		

		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, "%" + search.getSearch().toUpperCase() + "%", "%" + search.getSearch().toUpperCase() + "%", "%" + search.getSearch().toUpperCase() + "%");
		List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
		
		while(srs.next())
		{
			EmployeeModel employee = new EmployeeModel(srs.getString("FIRSTNAME"), srs.getString("LASTNAME"), srs.getString("EMAIL"), srs.getString("PHONE"), srs.getString("EMPLOYEEID"), srs.getString("IS_ADMIN"), srs.getString("IS_ACTIVE"), srs.getString("IS_TERMINATED"));
			employees.add(employee);
		}
		
		return employees;
		
		
		/*try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			// "SELECT * FROM products WHERE PRODUCT_NAME LIKE '%$pattern%' OR PRODUCT_DESCRIPTION LIKE '%$pattern%'"
			String query = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE UPPER(FIRSTNAME) LIKE ? OR UPPER(LASTNAME) LIKE ? OR UPPER(EMPLOYEEID) LIKE ?";
			
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			pt.setString(1, "%" + search.getSearch().toUpperCase() + "%");
			pt.setString(2, "%" + search.getSearch().toUpperCase() + "%");
			pt.setString(3, "%" + search.getSearch().toUpperCase() + "%");
			
			pt.execute();
			ResultSet rs = pt.getResultSet();
			
			List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
			
			while(rs.next())
			{
				EmployeeModel employee = new EmployeeModel(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("EMPLOYEEID"), rs.getString("IS_ADMIN"), rs.getString("IS_ACTIVE"), rs.getString("IS_TERMINATED"));
				employees.add(employee);
			}

        	pt.close();

            return employees;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in EmployeeDAO.");
			return null;
		}*/
	}
	
	
	@Override
	public boolean updateEmployees(List<EmployeeModel> employees) 
	{
		

		int i = 0;
		while(i < employees.size())
		{
			String query = "UPDATE nod3eke2u33fhtk2.authemployee SET IS_ADMIN = ?, IS_ACTIVE = ?, IS_TERMINATED = ? WHERE EMPLOYEEID = ?";
			
			int result = jdbcTemplate.update(query, employees.get(i).getAdmin(), 
					employees.get(i).getActive(), 
					employees.get(i).getTerminated(), 
					employees.get(i).getEmployeeid());
            i++;
		}
		
		return true;
		
		/*try 
		{
			int i = 0;
			while(i < employees.size())
			{
				// n1euzrfjibaye0bl
				// opp hack: nod3eke2u33fhtk2
				String query = "UPDATE nod3eke2u33fhtk2.authemployee SET IS_ADMIN = ?, IS_ACTIVE = ?, IS_TERMINATED = ? WHERE EMPLOYEEID = ?";
				
				PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
				
				pt.setString(1, employees.get(i).getAdmin());
				pt.setString(2, employees.get(i).getActive());
				pt.setString(3, employees.get(i).getTerminated());
				pt.setString(4, employees.get(i).getEmployeeid());
				
				System.out.println("admin:" + employees.get(i).getAdmin() + " active:" + employees.get(i).getActive() + " Term:" + employees.get(i).getTerminated() + " id:" + employees.get(i).getEmployeeid());
				
	            pt.executeUpdate();

	            pt.close();
	            i++;
			}

            return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in EmployeeDAO.");
			return false;
		}*/

	}

	@Override
	public boolean deleteEmployee(String employeeID) 
	{
		
		String query = "DELETE FROM nod3eke2u33fhtk2.authemployee WHERE EMPLOYEEID = ?";
		
		int result = jdbcTemplate.update(query, employeeID);
		
		return result > 0;
		
		/*try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			String query2 = "DELETE FROM nod3eke2u33fhtk2.authemployee WHERE EMPLOYEEID = ?";
			
			PreparedStatement pt2 = dbconn.dbConnect().prepareStatement(query2);
			
			System.out.println(employeeID);
			pt2.setString(1, employeeID);
            
            int result = pt2.executeUpdate();
            pt2.close();

            return (result > 0);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in EmployeeDAO.");
			return false;
		}*/
		
	}
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
