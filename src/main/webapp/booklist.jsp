<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.java_mvc.models.book" %>
    
<%@ page import="java.util.List"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="com.java_mvc.Dao.BookListDao"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>booklist</title>
</head>
<body>


	<table border='1' align='center'> 
		<tr> 
			<th>Book Name</th> 
			<th>Book Edition</th> 
			<th>Book Price</th> 
		</tr> 


		<% 	ServletContext servletcontext = request.getServletContext();
	Connection con = (Connection) servletcontext.getAttribute("db_connection");
		List<book> booklist = BookListDao.fetch_books(con);
		
		System.out.println(booklist);
		
		%>

		



<%		if (!booklist.isEmpty()) {  %>
			<jsp:useBean id="book" class="com.java_mvc.models.book" scope="request"/> 

	<% for (book bk : booklist) {	%>		
 		<jsp:setProperty name="book" property="bookname" value="<%= bk.getBookname() %>" /> 
		<jsp:setProperty name="book" property="bookedition" value="<%= bk.getBookedition() %>" /> 
		<jsp:setProperty name="book" property="bookprice" value= "<%= bk.getBookprice() %>" /> 


		<tr> 
			<td><jsp:getProperty name="book" property="bookname" /> </td> 
			<td><jsp:getProperty name="book" property="bookedition"/> </td> 
 			<td><jsp:getProperty name="book" property="bookprice"/> </td> 
		</tr> 
<% 			}%>
	<% 			}%>	

		
	</table> 

<a href="register.jsp">Register Book</a> 


</body>
</html>