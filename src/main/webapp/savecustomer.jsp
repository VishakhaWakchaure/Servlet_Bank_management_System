<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <form action="saveCustomer" method="post">
    
        Name : <input type="text" name="name"><br><br>
        
        Pan : <input type="text" name="pan" required="required"><br><br>
        
        <input type="submit" value="SAVE">
        
        </form>
</body>
</html>