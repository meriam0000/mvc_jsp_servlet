package com.java_mvc.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookRegisterDao {
	public static boolean register(String bookname,String bookedition,Float bookprice,Connection con) {
		
		boolean status=false;  
		



		 final String query="INSERT INTO BookData(BookName,BookEdition,BookPrice) VALUES(?,?,?)";
		  //generate the connection
		  		try {
		  			
		  			      
		  				PreparedStatement ps = con.prepareStatement(query);
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
