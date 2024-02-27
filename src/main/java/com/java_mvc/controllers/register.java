package com.java_mvc.controllers;

import java.io.IOException;
import java.sql.Connection;

import com.java_mvc.Dao.BookRegisterDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")

public class register extends HttpServlet {
	 

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String bookname=req.getParameter("bookname");
    String bookedition=req.getParameter("bookedition");
    Float bookprice= Float.parseFloat(req.getParameter("bookprice"));
    ServletContext  servletcontext=req.getServletContext();
    Connection con = (Connection) servletcontext.getAttribute("db_connection");
    
    
    if(BookRegisterDao.register(bookname, bookedition,bookprice,con)){  
    	  resp.sendRedirect("booklist");
    }  
    else{  
        System.out.print("sorry not registered");  
        RequestDispatcher rd=req.getRequestDispatcher("register.jsp");  
        rd.include(req,resp);  
    }  
      
	
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
}



}

