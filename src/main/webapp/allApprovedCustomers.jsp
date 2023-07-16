<%@page import="com.jsp.dto.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.service.BankManagerService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>All Approved Customers Detail</h1><br>
  
      <%BankManagerService bankManagerService=new  BankManagerService();
      
      List<Customer> customers=bankManagerService.viewAllApprovedCustomer();
      %>
      
      <table border="2px">
      <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Status</th>
            <th>Pan_No</th>
      </tr>
      
      <%for(Customer c:customers)
            	{
            	%>
      <tr> 
            <td><%=c.getId() %></td>
            <td><%=c.getName() %></td>
            <td><%=c.getStatus() %></td>
            <td><%=c.getPan().getPan_no()%></td>
      </tr>
     <% }%>
      
      </table>
</body>
</html>