package com.jsp.service;
	import java.util.List;

	import com.jsp.dao.AdminDao;
	import com.jsp.dto.Admin;
	import com.jsp.dto.BankAccount;
	import com.jsp.dto.BankManager;
	import com.jsp.dto.Customer;

	public class AdminService {

		AdminDao adminDao = new AdminDao();
		
		public Admin saveAdmin(Admin admin) {

			return adminDao.saveAdmin(admin);

		}

		public Admin getAdminById(int id) {
			if (id > 0) {
				return adminDao.getAdminById(id);
			} else {
				return null;
			}
		}

		public Admin updateAdmin(int id, Admin admin) {
			if (admin != null) {
				return adminDao.updateAdmin(id, admin);
			} else {
				return null;
			}
		}

		public boolean deleteAdminById(int id) {
			if (id > 0) {
				return adminDao.deleteAdminById(id);
			} else {
				return false;
			}
		}

		public List<BankManager> viewAllBankManagers() {

			return adminDao.viewAllBankManagers();
		}

		public List<Customer> viewAllCustomers() {

			return adminDao.viewAllCustomers();
		}

		public List<BankAccount> viewAllBankAccounts() {
			return adminDao.viewAllBankAccounts();
		}
	}


