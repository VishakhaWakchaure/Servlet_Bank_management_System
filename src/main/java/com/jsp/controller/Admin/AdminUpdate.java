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

	@WebServlet("/updateAdmin")
	public class AdminUpdate extends HttpServlet{

		AdminService adminService = new AdminService();

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			HttpSession httpSession = req.getSession();
			int id = (int) httpSession.getAttribute("aid");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			Admin a = new Admin();
			if (!email.isEmpty()) {
				a.setEmail(email);
			}
			if (!password.isEmpty()) {
				a.setPassword(password);
			}
			Admin admin = adminService.updateAdmin(id, a);
			if (admin != null) {
				httpSession.setAttribute("adminemail", admin.getEmail());
				PrintWriter printWriter = resp.getWriter();
				printWriter.write("<h1>" + admin.getEmail() + " Updated Succussfully</h1>");
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("admin.jsp");
				requestDispatcher.forward(req, resp);
			} else {
				PrintWriter printWriter = resp.getWriter();
				printWriter.write("<h1>UnAble to Update</h1>");
			}
		}
	}


