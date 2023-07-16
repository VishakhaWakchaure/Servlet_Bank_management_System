<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%HttpSession httpSession=request.getSession(); %>
<%String bmname=(String)httpSession.getAttribute("bmname"); %>
<h1 ><%=bmname %> Welcome To BankManager Portal</h1>

<form action="bankManagerController" method="post">

<input type="submit" name="getbyid" value="Get Account" ><br> <br>

<input type="submit" name="update" value="Update Account"><br> <br>

<input type="submit" name="delete" value="Delete Account"> <br> <br>

<input type="submit" value="View All Customers" name="viewallcustomers"><br><br>

 <input type="submit" value="View All Approved Customers" name="viewallapprovedcustomers"><br><br>
 
 <input type="submit" value="View All UnApproved Customers" name="viewallunapprovedcustomers"><br><br> 
 
 <input type="submit" value="Logout" name="logout"><br><br>        
</form>
</body>
</html>













