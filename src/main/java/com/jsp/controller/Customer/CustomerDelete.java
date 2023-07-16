package com.jsp.controller.Customer;
	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.jsp.service.CustomerService;

	@WebServlet("/deleteCustomer")
	public class CustomerDelete extends HttpServlet{

		CustomerService customerService=new CustomerService();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			HttpSession httpSession=req.getSession();
			int id=(int)httpSession.getAttribute("cid");
			
			boolean b=customerService.deleteCustomerById(id);
			if(b!=false)
			{
				PrintWriter printWriter=resp.getWriter();
				printWriter.write("<h1>Account Deleted Successfully</h1>");
			}else
			{
				PrintWriter printWriter=resp.getWriter();
				printWriter.write("<h1>Account Not Found</h1>");
			}
		}
	}


