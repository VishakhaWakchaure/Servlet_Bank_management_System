package com.jsp.dao;

	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;
	import javax.persistence.Query;

	import com.jsp.dto.Admin;
	import com.jsp.dto.BankAccount;
	import com.jsp.dto.BankManager;
	import com.jsp.dto.Customer;

	public class AdminDao {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vishakha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		public Admin saveAdmin(Admin admin) {
			if (admin != null) {
				entityTransaction.begin();
				entityManager.persist(admin);
				entityTransaction.commit();
				return admin;
			} else {
				return null;
			}
		}

		// get Amin by id
		public Admin getAdminById(int id) {
			Admin a = entityManager.find(Admin.class, id);
			return a;
		}

		// Update Admin
		public Admin updateAdmin(int id, Admin admin) {
			entityTransaction.begin();
			Admin a = entityManager.find(Admin.class, id);
			if (admin.getEmail() != null)
				a.setEmail(admin.getEmail());
			if (admin.getPassword() != null)
				a.setPassword(admin.getPassword());
			entityManager.persist(a);
			entityTransaction.commit();
			return a;
		}

		// delete Admin By Id
		public boolean deleteAdminById(int id) {
			entityTransaction.begin();
			Admin a = entityManager.find(Admin.class, id);
			entityManager.remove(a);
			entityTransaction.commit();
			return true;
		}

		public List<BankManager> viewAllBankManagers() {
			String jql = "SELECT b FROM BankManager b";
			Query query = entityManager.createQuery(jql);
			return query.getResultList();
		}

		public List<Customer> viewAllCustomers() {
			String jql = "SELECT c FROM Customer c";
			Query query = entityManager.createQuery(jql);
			return query.getResultList();
		}

		public List<BankAccount> viewAllBankAccounts() {
			String jql = "SELECT b FROM BankAccount b";
			Query query = entityManager.createQuery(jql);
			return query.getResultList();
		}

	}


