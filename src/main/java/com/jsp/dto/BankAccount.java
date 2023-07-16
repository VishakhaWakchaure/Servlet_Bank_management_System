package com.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class BankAccount {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private long account_no;
		private double balance;

		@OneToOne(mappedBy = "bankAccount")
		private Customer customer;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public long getAccount_no() {
			return account_no;
		}

		public void setAccount_no(long account_no) {
			this.account_no = account_no;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
	}


