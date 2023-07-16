package com.jsp.controller.Customer;

	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.jsp.dto.BankManager;
	import com.jsp.dto.Customer;
	import com.jsp.service.BankManagerService;
	import com.jsp.service.CustomerService;

	@WebServlet("/approveCustomer")
	public class ApproveCustomer extends HttpServlet {

		BankManagerService bankManagerService = new BankManagerService();
	    CustomerService customerService=new CustomerService();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			HttpSession httpSession = req.getSession();
			int cid =Integer.parseInt(req.getParameter("cid"));
			Customer c=customerService.getCustomerById(cid);
			int bmid = (int) httpSession.getAttribute("bmid");

			BankManager bm = bankManagerService.approveCustomerById(cid, bmid);
			if(bm!=null)
			{
				PrintWriter printWriter=resp.getWriter();
				printWriter.write("<h1> Customer "+c.getName()+" is Approved By BankManager "+bm.getName()+"</h1>");
			}
		}
	}


