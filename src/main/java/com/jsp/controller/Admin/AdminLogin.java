package com.jsp.controller.Admin;

	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.Admin;
	import com.jsp.service.AdminService;

	@WebServlet("/adminLogin")
	public class AdminLogin extends HttpServlet{

		AdminService adminService=new AdminService();
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			      int id=Integer.parseInt(req.getParameter("id"));
			      String password=req.getParameter("password");

			      Admin a=adminService.getAdminById(id);
			      if(a!=null && a.getId()==id && a.getPassword().equals(password))
			      {
			    	  RequestDispatcher requestDispatcher=req.getRequestDispatcher("admin.jsp");
			    	  requestDispatcher.forward(req, resp);
			      }else
			      {

				      HttpSession httpSession =req.getSession();
			    	  httpSession.setAttribute("adminpass", password);
			    	  httpSession.setAttribute("aid", id);
			    	  resp.setContentType("text/html");
			    	  PrintWriter printWriter=resp.getWriter();
			    	  printWriter.write("<h3>Invalid Name And ID</h3>");
			    	  
			    	  RequestDispatcher requestDispatcher=req.getRequestDispatcher("adminLogin.jsp");
			    	  requestDispatcher.include(req, resp);
			      }
		}
	}

