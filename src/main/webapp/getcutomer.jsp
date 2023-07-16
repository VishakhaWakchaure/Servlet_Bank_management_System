<%@page import="com.jsp.service.CustomerService"%>
<%@page import="com.jsp.dto.Customer"%>

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
       int id=(int)httpSession.getAttribute("cid");
       CustomerService customerService=new CustomerService();
       Customer c=customerService.getCustomerById(id);
       %>
       
       <table border="1px">
      <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Status</th>
            <th>Pan_No</th>
      </tr>
      
      <tr>
            <td><%=c.getId() %></td>
            <td><%=c.getName() %></td>
            <td><%=c.getStatus() %></td>
            <td><%=c.getPan().getPan_no()%></td>
      
      </tr>
      
      </table>
</body>
</html>