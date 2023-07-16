<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%HttpSession httpSession=request.getSession();
         
         httpSession.invalidate();
         response.setContentType("text/html");
         PrintWriter printWriter=response.getWriter();
         RequestDispatcher requestDispatcher=request.getRequestDispatcher("welcome.jsp");
         requestDispatcher.forward(request, response);
         printWriter.write("<h1>You Have Been Logged out</h1>");
        %>
</body>
</html>