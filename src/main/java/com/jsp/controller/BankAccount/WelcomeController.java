package com.jsp.controller.BankAccount;

	import java.io.IOException;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	@WebServlet("/welcome")
	public class WelcomeController extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String customer = req.getParameter("customer");
			String manager = req.getParameter("manager");
			String admin = req.getParameter("admin");

			if (customer != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("customerLogin.jsp");
				requestDispatcher.forward(req, resp);
				
			} else if (manager != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("bankManagerLogin.jsp");
				requestDispatcher.forward(req, resp);
				
			} else if (admin != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminLogin.jsp");
				requestDispatcher.forward(req, resp);
			}
		}
	}


