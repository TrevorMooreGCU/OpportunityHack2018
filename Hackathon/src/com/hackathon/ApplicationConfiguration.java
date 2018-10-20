package com.hackathon;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import com.hackathon.controller.EmployeeController;
import com.hackathon.controller.HomeController;
import com.hackathon.controller.LoginController;
import com.hackathon.controller.RegisterController;
import com.hackathon.controller.SearchController;
import com.hackathon.controller.UploadController;
import com.hackathon.services.business.ILoginService;
import com.hackathon.services.business.IRegisterService;
import com.hackathon.services.business.ImportService;
import com.hackathon.services.business.IEmployeeService;
import com.hackathon.services.business.IImportService;
import com.hackathon.services.business.LoginService;
import com.hackathon.services.business.RegisterService;
import com.hackathon.services.business.EmployeeService;
import com.hackathon.services.data.IRegistrationDAO;
import com.hackathon.services.data.ISecurityDAO;
import com.hackathon.services.data.ImportDAO;
import com.hackathon.services.data.IEmployeeDAO;
import com.hackathon.services.data.IImportDAO;
import com.hackathon.services.data.RegistrationDAO;
import com.hackathon.services.data.SecurityDAO;
import com.hackathon.services.data.EmployeeDAO;

@Configuration
public class ApplicationConfiguration 
{
	/// CONTROLLERS ///
	@Bean(name="homeController")
	public HomeController getHomeController()
	{
		return new HomeController();
	}
	@Bean(name="loginController")
	public LoginController getLoginController()
	{
		return new LoginController();
	}
	@Bean(name="registerController")
	public RegisterController getRegisterController()
	{
		return new RegisterController();
	}
	@Bean(name="searchController")
	public SearchController getSearchController()
	{
		return new SearchController();
	}
	@Bean(name="employeeController")
	public EmployeeController getEmployeeController()
	{
		return new EmployeeController();
	}
	
	
	/// BUSINESS SERVICES ///
	@Bean(name="loginService")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public ILoginService getLoginService()
	{
		return new LoginService();
	}
	@Bean(name="registerService")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IRegisterService getRegisterService()
	{
		return new RegisterService();
	}
	@Bean(name="employeeService")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IEmployeeService getEmployeeService()
	{
		return new EmployeeService();
	}
	@Bean(name="importService")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IImportService getImportService()
	{
		return new ImportService();
	}
	
	
	
	
	
	
	/// DATA SERVICES ///
	@Bean(name="securityDAO")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public ISecurityDAO getSecurityDAO()
	{
		return new SecurityDAO();
	}
	@Bean(name="registrationDAO")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IRegistrationDAO getRegistrationDAO()
	{
		return new RegistrationDAO();
	}
	@Bean(name="employeeDAO")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IEmployeeDAO getEmployeeDAO()
	{
		return new EmployeeDAO();
	}
	
	@Bean(name="importDAO")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IImportDAO getImportDAO()
	{
		return new ImportDAO();
	}

	@Bean(name="dataSource", destroyMethod = "close")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataSource getDataSource()
	{
		DataSource dataSource = new DataSource(); // org.apache.tomcat.jdbc.pool.DataSource;
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://y2fkufcdev0yjma3:t9ylcf9w4aapkdfl@tuy8t6uuvh43khkk.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/nod3eke2u33fhtk2");
	    dataSource.setUsername("y2fkufcdev0yjma3");
	    dataSource.setPassword("t9ylcf9w4aapkdfl"); 
	    dataSource.setInitialSize(1);
	    return dataSource;
	}
	

	
}
