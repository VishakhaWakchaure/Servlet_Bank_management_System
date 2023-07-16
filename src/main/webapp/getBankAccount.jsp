<%@page import="com.jsp.dto.BankAccount"%>
<%@page import="com.jsp.service.BankAccountService"%>
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

       int id=(int)httpSession.getAttribute("baid");
       
       BankAccountService bankAccountService=new BankAccountService();
       BankAccount ba=bankAccountService.getAccountDetailsById(id);
       %>
       
       <table border="1px">
      <tr>
            <th>ID</th>
            <th>Account_No</th>
            <th>Balance</th>
      </tr>
      
      <tr>
            <td><%=ba.getId() %></td>
            <td><%=ba.getAccount_no() %></td>
            <td><%=ba.getBalance() %></td>      
      </tr>
      
      </table>
</body>
</html>