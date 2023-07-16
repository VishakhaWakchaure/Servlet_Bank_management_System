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

	@WebServlet("/transfermoney")
	public class TransferMoney extends HttpServlet{

		BankAccountService accountService=new BankAccountService();
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			HttpSession httpSession=req.getSession();
			
			int sender_id=(int)httpSession.getAttribute("baid");
			int receiver_id=Integer.parseInt(req.getParameter("reciever_id"));
			
			int transferAmmount=Integer.parseInt(req.getParameter("transferammount"));
			BankAccount ba=accountService.transferMoney(sender_id,receiver_id, transferAmmount);
			if(ba!=null)
			{
				PrintWriter printWriter=resp.getWriter();
				printWriter.write("<h1> Money Tranfer Successfull and Your Balance is "+ba.getBalance()+"</h1>");
			}else
			{
				PrintWriter printWriter=resp.getWriter();
				printWriter.write("<h1> Unable To Transfer Money due To incorrect info</h1>");
			}
			
		}
	}


