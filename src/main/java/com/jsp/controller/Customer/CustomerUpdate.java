package com.jsp.controller.Customer;

	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.jsp.dto.Customer;
	import com.jsp.service.CustomerService;

	@WebServlet("/updateCustomer")
	public class CustomerUpdate extends HttpServlet {

		CustomerService customerService = new CustomerService();

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			HttpSession httpSession = req.getSession();
			int id = (int) httpSession.getAttribute("cid");
			String name = req.getParameter("name");
			String pan = req.getParameter("pan");
			Customer c = new Customer();
			if (!name.isEmpty()) {
				c.setName(name);
			}
			if (!pan.isEmpty()) {
				c.getPan().setPan_no(pan);
			}
			Customer customer = customerService.updateCustomer(id, c);
			if (customer != null) {
				httpSession.removeAttribute("cname");
				httpSession.setAttribute("cname", customer.getName());
				PrintWriter printWriter = resp.getWriter();
				printWriter.write("<h1>" + customer.getName() + " Updated Succussfully</h1>");
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("customer.jsp");
				requestDispatcher.forward(req, resp);
			} else {
				PrintWriter printWriter = resp.getWriter();
				printWriter.write("<h1>UnAble to Update</h1>");
			}
		}
	}


