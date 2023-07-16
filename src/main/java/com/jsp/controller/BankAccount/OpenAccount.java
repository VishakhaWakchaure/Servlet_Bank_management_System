package com.jsp.controller.BankAccount;
	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.jsp.dto.BankAccount;
	import com.jsp.service.BankAccountService;

	@WebServlet("/openAccount")
	public class OpenAccount extends HttpServlet {

		BankAccountService bankAccountService = new BankAccountService();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			HttpSession httpSession = req.getSession();
			int cid = (int) httpSession.getAttribute("cid");
			String cname=(String)httpSession.getAttribute("cname");
			BankAccount ba = bankAccountService.openAccountById(cid);
			if(ba!=null)
			{
				PrintWriter printWriter=resp.getWriter();
				httpSession.setAttribute("baid", ba.getId());
				printWriter.write("<h1>"+cname+" Your Account Is Open Successfully</h1>");
			}else
			{
				PrintWriter printWriter=resp.getWriter();
				printWriter.write("<h1>"+cname+" UnAble To Open Your Account</h1>");
			}
		}
	}

