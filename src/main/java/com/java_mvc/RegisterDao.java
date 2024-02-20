package com.java_mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
	public static boolean Register(String bookname,String bookedition,Float bookprice) {
		
		boolean status=false;  

		
		
		 final String query="INSERT INTO BookData(BookName,BookEdition,BookPrice) VALUES(?,?,?)";
		    
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException se){
				se.printStackTrace();
			}
		  //generate the connection
		  		try(Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","meriam","123456789");
		  				PreparedStatement ps = con.prepareStatement(query);){
		  				ps.setString(1, bookname);
		  				ps.setString(2, bookedition);
		  				ps.setFloat(3, bookprice);
		  				
	  			       ps.executeUpdate();
	  			       status=true;
////		  				if (count==1) {
//////		  				System.out.println("<h2>Record Is registered successfully</h2>");
//////		  			}
//////		  				else {
//////		  				System.out.println("<h2>Record is not registred succefully</h2>");
//////		  				}
//		  			
		  		} catch (SQLException e) {
		  			
		  			e.printStackTrace();
		  			
		  		} catch (Exception e) {
		  			
		  			e.printStackTrace();
		  			
		  		}
		  		return status;
			
	}
	
	
}
