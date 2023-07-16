<%@page import="com.jsp.dto.BankManager"%>
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
 <%HttpSession httpSession=request.getSession();
       int id=(int)httpSession.getAttribute("bmid");
       BankManagerService bankManagerService=new BankManagerService();
       BankManager bm=bankManagerService.getBankManagerById(id);
       %>
       
       <table border="1px" >
      <tr>
            <th>ID</th>
            <th>Name</th>
      </tr>
      
      <tr>
            <td><%=bm.getId() %></td>
            <td><%=bm.getName() %></td>
      </tr>
      
      </table>
</body>
</html>