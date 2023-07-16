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

	@WebServlet("/depositmoney")
	public class DepositMoney extends HttpServlet{

		BankAccountService accountService=new BankAccountService();
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			HttpSession httpSession=req.getSession();
			
			int cid=(int)httpSession.getAttribute("cid");
			int acc_id=(int)httpSession.getAttribute("baid");
			
			int depositAmmount=Integer.parseInt(req.getParameter("depositammount"));
			BankAccount ba=accountService.depositMoney(acc_id, cid, depositAmmount);
			if(ba!=null)
			{
				PrintWriter printWriter=resp.getWriter();
				printWriter.write("<h1> Ammount Deposit Successfully and Your Balance is "+ba.getBalance()+"</h1>");
			}else
			{
				PrintWriter printWriter=resp.getWriter();
				printWriter.write("<h1> Unable To deposit due To incorrect info</h1>");
			}
			
		}
	}

