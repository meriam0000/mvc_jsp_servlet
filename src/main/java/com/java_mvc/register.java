package com.java_mvc;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
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
    
    
    if(RegisterDao.Register(bookname, bookedition,bookprice)){  
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

