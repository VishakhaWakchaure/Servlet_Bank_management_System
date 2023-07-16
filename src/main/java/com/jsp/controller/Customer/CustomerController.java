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

	@WebServlet("/customerController")
	public class CustomerController extends HttpServlet{

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String save=req.getParameter("save");
			String getbyid=req.getParameter("getbyid");
			String delete=req.getParameter("delete");
			String update=req.getParameter("update");
			String bankAccount=req.getParameter("bankaccount");
			String logout=req.getParameter("logout");
			
			if(save!=null)
			{
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("savecustomer.jsp");
				requestDispatcher.forward(req, resp);
			}else if(getbyid!=null)
			{
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("getcustomer.jsp");
				requestDispatcher.forward(req, resp);
			}else if(delete!=null)
			{
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("deletecustomer.jsp");
				requestDispatcher.forward(req, resp);
			}else if(update!=null)
			{
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("updatecustomer.jsp");
				requestDispatcher.forward(req, resp);
			}else if(bankAccount!=null)
			{
				HttpSession httpSession=req.getSession();
				int id=(int)httpSession.getAttribute("cid");
				CustomerService customerService=new CustomerService();
				Customer c=customerService.getCustomerById(id);
				if(c.getStatus().equals("Approved"))
				{
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("bankAccountLogin.jsp");
				requestDispatcher.forward(req, resp);
				}else
				{
					
					resp.setContentType("text/html");
					RequestDispatcher requestDispatcher=req.getRequestDispatcher("customer.jsp");
					requestDispatcher.include(req, resp);
					PrintWriter printWriter=resp.getWriter();
					printWriter.write("<h4 style='color:red;'>"+c.getName()+" First Get Approved By BankManager</h4>");
				}
				
			}else if(logout!=null)
			{
				
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("logoutCustomer.jsp");
				requestDispatcher.forward(req, resp);
			}
		}
	}


