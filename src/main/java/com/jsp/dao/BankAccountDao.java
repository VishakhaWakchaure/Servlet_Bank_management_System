package com.jsp.dao;

	import java.util.Random;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;
	import com.jsp.dto.BankAccount;
	import com.jsp.dto.Customer;
	import com.jsp.service.CustomerService;

	public class BankAccountDao {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vishakha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		CustomerService customerService=new CustomerService();
		
		Random r=new Random();

		// open account by id
		public BankAccount openAccountById(int c_id) {

			Customer c = customerService.getCustomerById(c_id);
			BankAccount bank=c.getBankAccount();

			if (c != null && bank==null) {
				entityTransaction.begin();
				BankAccount ba = new BankAccount();
				ba.setBalance(0);
				long account_no=r.nextLong(10000356l);
				ba.setAccount_no(account_no);
				c.setBankAccount(ba);
				customerService.updateCustomer(c_id, c);
				entityTransaction.commit();
				return ba;
			} else {
				return null;
			}
		}

		// Get Account details By Id
		public BankAccount getAccountDetailsById(int acc_id) {
			
			BankAccount ba = entityManager.find(BankAccount.class, acc_id);
			if (ba!=null) {
				return ba;
			} else {
				return null;
			}
		}

		// delete Account By Id
		public boolean deleteBankAccountById(int c_id) {
			
			BankAccount ba = customerService.getCustomerById(c_id).getBankAccount();
			if (ba != null) {
				entityTransaction.begin();
				customerService.deleteCustomerById(c_id);
				entityTransaction.commit();
				return true;
			} else {
				return false;
			}
		}

		// deposit money

		public BankAccount depositMoney(int acc_id, int c_id, long depositAmmout) {
			if (acc_id > 0 && c_id > 0) {
				entityTransaction.begin();
				Customer c = customerService.getCustomerById(c_id);
				BankAccount ba = entityManager.find(BankAccount.class, acc_id);
				if (c!=null && ba!=null) {
					ba.setBalance(ba.getBalance() + depositAmmout);
					entityManager.persist(ba);
					entityTransaction.commit();

					return ba;
				} else {
					return null;
				}
			} else {
				return null;
			}
		}

		// widthraw money
		public BankAccount withdrawMoney(int acc_id, long withdrawlMoney) {

			if (acc_id > 0) {
				BankAccount ba = entityManager.find(BankAccount.class, acc_id);
				if (ba.getBalance() >= withdrawlMoney) {
					entityTransaction.begin();
					ba.setBalance(ba.getBalance() - withdrawlMoney);
					entityManager.persist(ba);
					entityTransaction.commit();
					return ba;
				} else {
					return null;
				}
			} else {
				return null;
			}
		}

		public BankAccount transferMoney(int senderAcc_id, int receiverAcc_id, long transferAmmount) {
			if (senderAcc_id > 0 && receiverAcc_id > 0) {
				BankAccount senderAccount = entityManager.find(BankAccount.class, senderAcc_id);
				BankAccount receiverAccount = entityManager.find(BankAccount.class, receiverAcc_id);
				if (senderAccount != null && receiverAccount != null && senderAccount.getBalance() >= transferAmmount) {
					entityTransaction.begin();
					senderAccount.setBalance(senderAccount.getBalance() - transferAmmount);
					receiverAccount.setBalance(receiverAccount.getBalance() + transferAmmount);
					entityManager.persist(senderAccount);
					entityManager.persist(receiverAccount);
					entityTransaction.commit();
					return senderAccount;
				} else {
					return null;
				}

			} else {
				return null;
			}
		}
	}

