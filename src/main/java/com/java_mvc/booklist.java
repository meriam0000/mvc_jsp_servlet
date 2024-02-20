package com.java_mvc;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/booklist")
public class booklist extends HttpServlet {

	
	private static final String query="SELECT id ,BookName,BookEdition,BookPrice  From BookData";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//load jdbc driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException se){
			se.printStackTrace();
		}
		//generate the connection
		try(Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","meriam","123456789");
				PreparedStatement ps = con.prepareStatement(query);){
				ResultSet rs=ps.executeQuery();
	            List<book> books = new ArrayList<>();

				while(rs.next()) {
			        book book = new book();
			        book.setbookname(rs.getString(2));
			        book.setbookedition(rs.getString(3));
			        book.setbookprice(rs.getFloat(4));
			        books.add(book);
                     
				}
				rs.close();
				ps.close();
				con.close();
				req.setAttribute("books", books);
				System.out.print(books);
				RequestDispatcher dispatcher =req.getRequestDispatcher("booklist.jsp");
				dispatcher.forward(req, resp);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}


