package com.jsp.controller.Admin;

	import java.io.IOException;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	@WebServlet("/adminController")
	public class AdminController extends HttpServlet{

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String register=req.getParameter("register");
			String getbyid = req.getParameter("getbyid");
			String delete = req.getParameter("delete");
			String update = req.getParameter("update");
			String viewAllManagers = req.getParameter("viewallmanagers");
			String viewAllCustomers = req.getParameter("viewallcustomers");
			String viewAllBankAccounts = req.getParameter("viewallbankaccounts");
			String logout=req.getParameter("logout");

			if(register!=null) {
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("adminsave.jsp");
				requestDispatcher.forward(req, resp);
			}
			
			if (getbyid != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("getadmin.jsp");
				requestDispatcher.forward(req, resp);
				
			} else if (delete != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("deleteAdmin.jsp");
				requestDispatcher.forward(req, resp);
				
			} else if (update != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateAdmin.jsp");
				requestDispatcher.forward(req, resp);
				
			} else if (viewAllManagers != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewallmanagers.jsp");
				requestDispatcher.forward(req, resp);
				
			} else if (viewAllCustomers!= null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewAllcustomer.jsp");
				requestDispatcher.forward(req, resp);
				
			}else if (viewAllBankAccounts != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewallbankaccount.jsp");
				requestDispatcher.forward(req, resp);
				
			}else if (logout != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("logoutAdmin.jsp");
				requestDispatcher.forward(req, resp);
			}
		
		}
	}


