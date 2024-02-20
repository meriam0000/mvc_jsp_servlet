<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"  href="css/bootstrap.css">

<title>Register Books</title>

</head>
<body>

<form action="register" method='post'>
<div class="mb-3">
  <label for="Name" class="form-label">bookName</label>
  <input  type="text" class="form-control" id="Name" name="bookname" placeholder="book name">
</div>
<div class="mb-3">
  <label for="Price" class="form-label">book price</label>
  <input  type="text" class="form-control" id="price"  name ="bookprice" placeholder="Book price" >
</div>
<div class="mb-3">
  <label for="edition" class="form-label">Book edition</label>
  <input  type="text" class="form-control" id="edition"  name='bookedition' placeholder=" Book edition">
</div>

<button type="submit" class="btn btn-success">Submit</button>

</form>
<a href="/servlet-MVC-JSP/booklist" class="link-primary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">Book List</a>

</body>
</html>