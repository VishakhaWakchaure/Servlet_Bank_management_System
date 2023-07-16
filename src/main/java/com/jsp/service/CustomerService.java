package com.jsp.service;

import com.jsp.dao.CustomerDao;
import com.jsp.dto.Customer;

public class CustomerService {
	

		CustomerDao customerDao = new CustomerDao();

		public Customer saveCustomer(Customer customer) {
			return customerDao.saveCustomer(customer);
		}

		public Customer getCustomerById(int id) {
			if (id > 0) {
				return customerDao.getCustomerById(id);
			} else {
				return null;
			}
		}

		public Customer updateCustomer(int c_id, Customer customer) {
			if (customer != null) {
				return customerDao.updateCustomer(c_id, customer);
			} else {
				return null;
			}
		}

		public boolean deleteCustomerById(int id) {
			if (id > 0) {
				return customerDao.deleteCustomerById(id);
			} else {
				return false;
			}
		}
	}

		
	

