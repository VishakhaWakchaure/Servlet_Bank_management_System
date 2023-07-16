<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%  HttpSession httpSession =request.getSession(); 
       String cname=(String)httpSession.getAttribute("cname");
       %>
       <h1 ><%=cname %> Welcome To Customer Portal </h1>
        <form action="customerController" method="post">
        
                <input type="submit" value="Get Account" name="getbyid"><br><br>
                <input type="submit" value="Delete Account" name="delete"><br><br>
                <input type="submit" value="Update Account" name="update"><br><br>        
                <input type="submit" value="Bank Account" name="bankaccount"><br><br> 
                <input type="submit" value="Logout" name="logout"><br><br>        
                            
        </form>
</body>
</html>