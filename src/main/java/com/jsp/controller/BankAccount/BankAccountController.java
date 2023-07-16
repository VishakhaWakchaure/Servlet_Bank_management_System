package com.jsp.controller.BankAccount;

	import java.io.IOException;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	@WebServlet("/bankAccountController")
	public class BankAccountController extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String getbyid = req.getParameter("getbyid");
			String delete = req.getParameter("delete");
			String deposit = req.getParameter("deposit");
			String withdraw = req.getParameter("withdraw");
			String transfer = req.getParameter("transfer");
			String logout=req.getParameter("logout");

			if (getbyid != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("getBankAccount.jsp");
				requestDispatcher.forward(req, resp);
				
				
			} else if (delete != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("deleteBankAccount.jsp");
				requestDispatcher.forward(req, resp);
				
				
			} else if (deposit != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("depositmoney.jsp");
				requestDispatcher.forward(req, resp);
				
				
			} else if (withdraw != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("withdrawmoney.jsp");
				requestDispatcher.forward(req, resp);
				
				
			} else if (transfer != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("transfermoney.jsp");
				requestDispatcher.forward(req, resp);
				
				
			}else if (logout != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("logoutBankAccount.jsp");
				requestDispatcher.forward(req, resp);
			}
		}
	}

