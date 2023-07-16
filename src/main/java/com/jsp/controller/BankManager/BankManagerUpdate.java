package com.jsp.controller.BankManager;

	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.jsp.dto.BankManager;
	import com.jsp.service.BankManagerService;

	@WebServlet("/updateBankManager")
	public class BankManagerUpdate extends HttpServlet{

		BankManagerService bankManagerService = new BankManagerService();

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			HttpSession httpSession = req.getSession();
			int id = (int) httpSession.getAttribute("bmid");
			String name = req.getParameter("name");
			BankManager bm = new BankManager();
			if (!name.isEmpty()) {
				bm.setName(name);
			}
			BankManager bankManager = bankManagerService.updateBankManager(id, bm);
			if (bankManager != null) {
				httpSession.removeAttribute("bmname");
				httpSession.setAttribute("bmname", bankManager.getName());
				PrintWriter printWriter = resp.getWriter();
				printWriter.write("<h1>" + bankManager.getName() + " Updated Succussfully</h1>");
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("bankManager.jsp");
				requestDispatcher.forward(req, resp);
			} else {
				PrintWriter printWriter = resp.getWriter();
				printWriter.write("<h1>UnAble to Update</h1>");
			}
		}
	}


