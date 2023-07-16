package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.jsp.dto.BankManager;
import com.jsp.dto.Customer;

public class BankManagerDao {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vishakha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		///save 
		public BankManager saveBankManager(BankManager bankManager) {
			entityTransaction.begin();
			entityManager.persist(bankManager);
			entityTransaction.commit();
			return bankManager;
		}

		// Get manager By Id
		public BankManager getBankManagerById(int id) {
			BankManager bm = entityManager.find(BankManager.class, id);
			return bm;
		}

		// Update manager
		public BankManager updateBankManager(int m_id, BankManager bankManager) {

			BankManager manager = getBankManagerById(m_id);
			if (manager != null) {
				entityTransaction.begin();
				if (bankManager.getName() != null)
					manager.setName(bankManager.getName());
				entityManager.persist(manager);
				entityTransaction.commit();
				return manager;
			} else {
				return null;
			}

		}

		// delete manager By Id
		public boolean deleteBankManagerById(int id) {
			entityTransaction.begin();
			BankManager bm = getBankManagerById(id);
			if (bm != null) {
				entityManager.remove(bm);
				entityTransaction.commit();
				return true;
			} else {
				return false;
			}
		}
     //veiw All
		public List<Customer> viewAllCustomer() {
			String jql = "SELECT c FROM Customer c";
			Query query = entityManager.createQuery(jql);
			return query.getResultList();
		}
	}

