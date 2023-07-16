package com.jsp.controller.BankManager;
	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.jsp.service.BankManagerService;

	@WebServlet("/deleteBankManager")
	public class BankManagerDelete extends HttpServlet{

		BankManagerService bankManagerService=new BankManagerService();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			HttpSession httpSession=req.getSession();
			int id=(int)httpSession.getAttribute("bmid");
			
			boolean b=bankManagerService.deleteBankManagerById(id);
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

