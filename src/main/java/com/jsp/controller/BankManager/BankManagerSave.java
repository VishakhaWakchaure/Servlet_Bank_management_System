package com.jsp.controller.BankManager;

	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.jsp.dto.BankManager;
	import com.jsp.service.BankManagerService;

	@WebServlet("/saveBankManager")
	public class BankManagerSave extends HttpServlet{

		BankManagerService bankManagerService=new BankManagerService();
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String name = req.getParameter("name");
			BankManager bankManager = new BankManager();
			bankManager.setName(name);

			BankManager bm = bankManagerService.saveBankManager(bankManager);
			if (bm != null) {
				PrintWriter printWriter = resp.getWriter();
				printWriter.write("<h1>" + name + " Your Account Saved Successfully</h1>");
			} else {
				PrintWriter printWriter = resp.getWriter();
				printWriter.write("<h1>Account Not Saved Try Again</h1>");
			}

		}
	}

