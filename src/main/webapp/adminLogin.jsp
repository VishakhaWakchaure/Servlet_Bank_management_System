<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <h4>Goto SignUp If You Dont Have Account</h4>
      
      <a href="saveadmin.jsp"><button>SignUp</button></a><br>
      
      <h4>Login Here If You Already Have Account</h4><br>
      
     <form action="adminLogin" method="post">
     
    Enter ID : <input type="number" name="id" min="1" required="required"><br><br>
    
    Enter Password : <input type="password" name="password" required="required"><br><br>
    
    <input type="submit" value="Login">
    
     </form>
</body>
</html>