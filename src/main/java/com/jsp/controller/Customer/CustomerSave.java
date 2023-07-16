package com.jsp.controller.Customer;

	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.jsp.dto.Customer;
	import com.jsp.dto.Pan;
	import com.jsp.service.CustomerService;

	@WebServlet("/saveCustomer")
	public class CustomerSave extends HttpServlet {

		CustomerService customerService = new CustomerService();

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String name = req.getParameter("name");
			String pan_no = req.getParameter("pan");

			Pan pan = new Pan();
			pan.setPan_no(pan_no);

			Customer customer = new Customer();
			customer.setName(name);
			customer.setPan(pan);

			Customer c = customerService.saveCustomer(customer);
			if (c != null) {
				PrintWriter printWriter = resp.getWriter();
				printWriter.write("<h1>" + name + " Your Account Saved Successfully</h1>");
			} else {
				PrintWriter printWriter = resp.getWriter();
				printWriter.write("<h1>Account Not Saved Try Again</h1>");
			}

		}
	}


