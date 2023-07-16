package com.jsp.controller.BankAccount;
	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.jsp.dto.BankAccount;
	import com.jsp.service.BankAccountService;
	import com.jsp.service.CustomerService;

@WebServlet("/bankAccountLogin")
	public class BankAccountLogin extends HttpServlet{

		BankAccountService bankAccountService=new BankAccountService();
		CustomerService customerService=new CustomerService();
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			HttpSession httpSession=req.getSession();
			String id=req.getParameter("id");
			  int acc_id=Integer.parseInt(id);
		      int cid=(int)httpSession.getAttribute("cid");
		      
		      BankAccount ba=customerService.getCustomerById(cid).getBankAccount();
		      if(ba!=null && ba.getId()==acc_id)
		      {  
		    	  httpSession.setAttribute("baid", acc_id);
		    	  RequestDispatcher requestDispatcher=req.getRequestDispatcher("bankAccount.jsp");
	    	  requestDispatcher.forward(req, resp);
		    	  
		      }else
		      {
		    	  resp.setContentType("text/html");
		    	  PrintWriter printWriter=resp.getWriter();
		    	  printWriter.write("<h3>Invalid Account ID</h3>");
		    	  RequestDispatcher requestDispatcher=req.getRequestDispatcher("bankAccountLogin.jsp");
		    	  requestDispatcher.include(req, resp);
		      }
		}
	}


