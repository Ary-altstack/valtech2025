package servlets;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class LoadConfigListener implements ServletContextListener {
	

@Override
public void contextInitialized(ServletContextEvent sce) {
	
	Properties properties = new Properties();
	ServletContext sc = sce.getServletContext();
	
	try (InputStream is = sc.getResourceAsStream("/WEB-INF/config.properties")) {
		if(is == null) {
			throw new RuntimeException("File not found!");
		}
		properties.load(is);
		String url = properties.getProperty("url");
		System.out.println("url-----"+url);
		String user = properties.getProperty("user");
		String driver = properties.getProperty("driver");
		String password = properties.getProperty("password");
		
		Class.forName(driver);
		sc.setAttribute("url",url);
		sc.setAttribute("user",user);
		sc.setAttribute("password", password);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
			
			
	System.out.println("First piece of code that will be executed");
	System.out.println("Loading....Config....done");
	System.out.println("Creating Database Connection Pools");
	ServletContext application = sce.getServletContext();
	
}

@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Closing all Database Connections in the Connection Pools");

	}
}
