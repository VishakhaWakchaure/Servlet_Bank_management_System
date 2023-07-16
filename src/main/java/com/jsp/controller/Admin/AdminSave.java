package com.jsp.controller.Admin;
	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import com.jsp.dto.Admin;
	import com.jsp.service.AdminService;

	@WebServlet("/saveAdmin")
	public class AdminSave extends HttpServlet {

		AdminService adminService = new AdminService();

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String email = req.getParameter("email");
			String password = req.getParameter("password");

			Admin admin = new Admin();
			admin.setEmail(email);
			admin.setPassword(password);

			Admin a = adminService.saveAdmin(admin);
			if (a != null) {
				PrintWriter printWriter = resp.getWriter();
				printWriter.write("<h1>" + email + " Your Account Saved Successfully</h1>");
			} else {
				PrintWriter printWriter = resp.getWriter();
				printWriter.write("<h1>Account Not Saved Try Again</h1>");
			}

		}
	}


