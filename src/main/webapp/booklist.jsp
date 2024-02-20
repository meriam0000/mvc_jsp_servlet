<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.java_mvc.book" %>
     <%@ page import="java.util.List" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>booklist</title>
</head>
<body>
<table border='1' align='center' >
			<tr>
		
			<th> Book Name </th>
				<th> Book Edition </th>
				<th> Book Price </th>
				</tr>
				
			
	
    <%
    List<book> books = (List<book>) request.getAttribute("books");
    if (books != null) {
        for (book book : books) {
    %>      <tr>
            <td><%= book.getbookname() %></td>
            <td><%= book.getbookedition() %></td>
            <td><%= book.getbookprice() %></td>
            </tr>
    <%
        }
    }
    %>

			 </table>
			
<a href="register.jsp" >Register Book</a>
				
				
</body>
</html>