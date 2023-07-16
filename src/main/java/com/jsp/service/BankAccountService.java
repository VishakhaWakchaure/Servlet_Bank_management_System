package com.jsp.service;

	import com.jsp.dao.BankAccountDao;
	import com.jsp.dto.BankAccount;

	public class BankAccountService {

		BankAccountDao bdao = new BankAccountDao();

		
		//openAccount Method
		public BankAccount openAccountById(int p_id) {

			return bdao.openAccountById(p_id);
		}

		//get by id 
		public BankAccount getAccountDetailsById(int acc_id) {

			return bdao.getAccountDetailsById(acc_id);
		}
          
		//delete 
		public boolean deleteBankAccountById(int c_id) {

			return bdao.deleteBankAccountById(c_id);
		}

		   //deposite money
		public BankAccount depositMoney(int acc_id, int p_id, long depositAmmout) {

			return bdao.depositMoney(acc_id, p_id, depositAmmout);
		}
      
		
		//withDrowMethod
		public BankAccount withdrawMoney(int acc_id, long withdrawlMoney) {

			return bdao.withdrawMoney(acc_id, withdrawlMoney);
		}
          
		
		//transferMoney
		public BankAccount transferMoney(int senderAcc_id, int receiverAcc_id, long transferAmmount) {

			return bdao.transferMoney(senderAcc_id, receiverAcc_id, transferAmmount);
		}
	}


