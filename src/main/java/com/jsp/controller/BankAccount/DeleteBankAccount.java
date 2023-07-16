package com.jsp.controller.BankAccount;
	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.jsp.service.BankAccountService;

	@WebServlet("/")
	public class DeleteBankAccount extends HttpServlet{

		BankAccountService bankAccountService=new BankAccountService();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			HttpSession httpSession=req.getSession();
			
			int c_id=(int)httpSession.getAttribute("cid");
			
			boolean b=bankAccountService.deleteBankAccountById(c_id);
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


