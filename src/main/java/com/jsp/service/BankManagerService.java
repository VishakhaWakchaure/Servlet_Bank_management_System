package com.jsp.service;

	import java.util.ArrayList;
	import java.util.List;

	import com.jsp.dao.BankManagerDao;
	import com.jsp.dto.BankManager;
	import com.jsp.dto.Customer;

	public class BankManagerService {

		BankManagerDao bManagerDao = new BankManagerDao();
		CustomerService customerService = new CustomerService();

		public List<Customer> viewAllCustomer() {

			return bManagerDao.viewAllCustomer();
		}

		public List<Customer> viewAllApprovedCustomer() {
			List<Customer> approvedCustomers = new ArrayList<>();
			List<Customer> customers = bManagerDao.viewAllCustomer();

			if (!customers.isEmpty()) {
				for (Customer c : customers) {
					if (c.getStatus().equalsIgnoreCase("Approved")) {
						approvedCustomers.add(c);
					}
				}
			} else {
				return null;
			}
			return approvedCustomers;
		}

		public List<Customer> viewAllUnApprovedCustomer() {
			List<Customer> unApprovedCustomers = new ArrayList<>();
			List<Customer> customers = bManagerDao.viewAllCustomer();

			if (!customers.isEmpty()) {
				for (Customer c : customers) {
					if (c.getStatus().equalsIgnoreCase("UnApproved")) {
						unApprovedCustomers.add(c);
					}
				}
			} else {
				return null;
			}
			return unApprovedCustomers;
		}

		public BankManager approveCustomerById(int c_id, int m_id) {

			if (c_id > 0 && m_id > 0) {
				BankManager bm = getBankManagerById(m_id);
				Customer c = customerService.getCustomerById(c_id);
				if (c_id > 0 && bm != null && c.getPan() != null && c.getStatus().equalsIgnoreCase("UnApproved")) {
					c.setStatus("Approved");
					customerService.updateCustomer(c_id, c);
					return bm;
				} else {
					return null;
				}
			} else {
				return null;
			}

		}

		public BankManager saveBankManager(BankManager bankManager) {
			if (bankManager != null) {
				return bManagerDao.saveBankManager(bankManager);
			} else {
				return null;
			}
		}

		public BankManager getBankManagerById(int id) {
			if (id > 0) {
				return bManagerDao.getBankManagerById(id);
			} else {
				return null;
			}
		}

		public BankManager updateBankManager(int m_id, BankManager bankManager) {

			if (m_id > 0 && bankManager != null) {
				return bManagerDao.updateBankManager(m_id, bankManager);
			} else {
				return null;
			}
		}

		public boolean deleteBankManagerById(int id) {
			if (id > 0) {
				return bManagerDao.deleteBankManagerById(id);
			} else {
				return false;
			}
		}
	}


