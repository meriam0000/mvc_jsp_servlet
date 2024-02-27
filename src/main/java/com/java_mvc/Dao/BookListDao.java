package com.java_mvc.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java_mvc.models.book;

public class BookListDao {
	private static final  String   query="SELECT * FROM BookData";
	private static List<book> books = new ArrayList<>();
	public static List<book> fetch_books(Connection con){
		 
		 
		 
		 try {
			 PreparedStatement ps = con.prepareStatement(query);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next()) {
				 book book=new book(rs.getString(2),rs.getString(4),rs.getFloat(3));
				 books.add(book);
				 
				 
			 }
			 
			 rs.close();
			 ps.close();
			 con.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return books;
		 
		 
		 
		 
		 
	 }
	
	
}
