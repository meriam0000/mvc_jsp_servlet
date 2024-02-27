package com.java_mvc.listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class listenerdb implements ServletContextListener{
	
  public listenerdb() {
	  
  }
  @Override
  public void contextInitialized(ServletContextEvent sce) {
  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch(ClassNotFoundException se){
		se.printStackTrace();
	}
  try {
	 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","meriam","123456789");
	 sce.getServletContext().setAttribute("db_connection", con);
  }catch (SQLException e) {
		
		e.printStackTrace();
		
	} }
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
	   Connection connexion =(Connection) sce.getServletContext().getAttribute("db_connection");
	   if(connexion !=null) {
		   try {connexion.close();}
		   catch(SQLException e) {
			   e.printStackTrace();

		   }
		   
	   }
	   
	   
	  
  }
  
  

}