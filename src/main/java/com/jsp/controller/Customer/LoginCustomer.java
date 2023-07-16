package com.jsp.controller.Customer;
	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.jsp.dto.Customer;
	import com.jsp.service.CustomerService;

	@WebServlet("/customerLogin")
	public class LoginCustomer extends HttpServlet{

		CustomerService customerService=new CustomerService();
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			      int id=Integer.parseInt(req.getParameter("id"));
			      String name=req.getParameter("name");
			      
			      Customer c=customerService.getCustomerById(id);
			      if(c!=null && c.getId()==id && c.getName().equals(name))
			      {
				      HttpSession httpSession =req.getSession();
			    	  httpSession.setAttribute("cname", name);
			    	  httpSession.setAttribute("cid", id);
			    	  RequestDispatcher requestDispatcher=req.getRequestDispatcher("customer.jsp");
			    	  requestDispatcher.forward(req, resp);
			      }else
			      {
			    	  resp.setContentType("text/html");
			    	  PrintWriter printWriter=resp.getWriter();
			    	  printWriter.write("<h3>Invalid Name And ID</h3>");
			    	  RequestDispatcher requestDispatcher=req.getRequestDispatcher("customerLogin.jsp");
			    	  requestDispatcher.include(req, resp);
			      }
		}
	}


