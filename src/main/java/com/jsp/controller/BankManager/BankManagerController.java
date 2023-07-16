package com.jsp.controller.BankManager;



	import java.io.IOException;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	@WebServlet("/bankManagerController")
	public class BankManagerController extends HttpServlet{

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String getbyid=req.getParameter("getbyid");
			String delete=req.getParameter("delete");
			String update=req.getParameter("update");
			String allApvd=req.getParameter("viewallapprovedcustomers");
			String allUnApvd=req.getParameter("viewallunapprovedcustomers");
			String allCustomers=req.getParameter("viewallcustomers");
			String logout=req.getParameter("logout");

			if(getbyid!=null)
			{
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("getBankManager.jsp");
				requestDispatcher.forward(req, resp);
			}else if(delete!=null)
			{
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("deleteBankManager.jsp");
				requestDispatcher.forward(req, resp);
			}else if(update!=null)
			{
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("updateBankManager.jsp");
				requestDispatcher.forward(req, resp);
			}else if(allApvd!=null)
			{
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("allApprovedCustomers.jsp");
				requestDispatcher.forward(req, resp);
			}else if(allUnApvd!=null)
			{
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("allunapprovedCustomers.jsp");
				requestDispatcher.forward(req, resp);
			}else if(allCustomers!=null)
			{
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("viewallcustomer.jsp");
				requestDispatcher.forward(req, resp);
			}else if(logout!=null)
			{
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("logoutBankManager.jsp");
				requestDispatcher.forward(req, resp);
			}
		}
	}


