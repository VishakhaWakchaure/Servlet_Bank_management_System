package com.jsp.dao;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;
	import com.jsp.dto.Customer;

	public class CustomerDao {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vishakha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		//save Customer
		public Customer saveCustomer(Customer customer)
		{
			if(customer!=null)
			{
				entityTransaction.begin();
				customer.setStatus("UnApproved");
				entityManager.persist(customer);
				entityTransaction.commit();
				return customer;
			}
			return null;
		}
		
		//getBy id customer
		public Customer getCustomerById(int id) {
			Customer c = entityManager.find(Customer.class, id);
			return c;
		}
		
		//update customer
		public Customer updateCustomer(int c_id, Customer customer) {
			Customer c1 = getCustomerById(c_id);
			if (c1 != null) {
				entityTransaction.begin();
				if (customer.getName() != null)
					c1.setName(customer.getName());
				if(customer.getBankAccount()!=null)
				{
					c1.setBankAccount(customer.getBankAccount());
				}
				if (customer.getPan()!=null)
					c1.getPan().setPan_no(customer.getPan().getPan_no());
				entityManager.persist(c1);
				entityTransaction.commit();
				return c1;
			} else {
				return null;
			}
		}

		// delete Customer By Id
		public boolean deleteCustomerById(int id) {
			entityTransaction.begin();
			Customer c = getCustomerById(id);
			if (c != null) {
				entityManager.remove(c);
				entityTransaction.commit();
				return true;
			} else {
				return false;
			}
		}
	

	}

