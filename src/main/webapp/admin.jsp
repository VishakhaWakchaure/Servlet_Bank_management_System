<%@page import="com.jsp.dto.Admin"%>
<%@page import="com.jsp.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <%  HttpSession httpSession =request.getSession();  %>
     <% int id=(int)httpSession.getAttribute("aid"); %> 
     
       <% AdminService adminService=new AdminService(); %>
      <% Admin a=adminService.getAdminById(id);%> 
       
        <h1> Welcome To Admin Portal </h1>
        
         <form action="adminController" method="post">
         
                <input type="submit" value="Get Account" name="getbyid"><br><br>
                
                <input type="submit" value="Delete Account" name="delete"><br><br>
                
                <input type="submit" value="Update Account" name="update"><br><br>
                
                <input type="submit" value="View All Managers" name="viewallmanagers"><br><br>
                
                <input type="submit" value="View All Customers" name="viewallcustomers"><br><br>
                
                <input type="submit" value="View All BankAccounts" name="viewallbankaccounts"><br><br>
                
                <input type="submit" value="Logout" name="logout"><br><br>        
                
         </form>
</body>
</html>