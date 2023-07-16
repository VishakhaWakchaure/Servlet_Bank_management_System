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

	@WebServlet("/bankManagerLogin")
	public class LoginBankManager extends HttpServlet{

		BankManagerService bankManagerService=new BankManagerService();
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			int id=Integer.parseInt(req.getParameter("id"));
		      String name=req.getParameter("name");
		      
		      BankManager bm=bankManagerService.getBankManagerById(id);
		      if(bm!=null && bm.getId()==id && bm.getName().equals(name))
		      {
			      HttpSession httpSession =req.getSession();
		    	  httpSession.setAttribute("bmname", name);
		    	  httpSession.setAttribute("bmid", id);
		    	  RequestDispatcher requestDispatcher=req.getRequestDispatcher("bankManager.jsp");
		    	  requestDispatcher.forward(req, resp);
		      }else
		      {
		    	  resp.setContentType("text/html");
		    	  PrintWriter printWriter=resp.getWriter();
		    	  printWriter.write("<h3 style='color :red;'>Invalid Name And ID</h3>");
		    	  RequestDispatcher requestDispatcher=req.getRequestDispatcher("bankManagerLogin.jsp");
		    	  requestDispatcher.include(req, resp);
		      }
		}
	}


