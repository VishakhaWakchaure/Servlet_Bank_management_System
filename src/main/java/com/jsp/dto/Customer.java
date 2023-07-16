package com.jsp.dto;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.jsp.dto.BankAccount;
import  com.jsp.dto.Pan;

@Entity
public class Customer {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
     private int id;
	private String name;
	private String status;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Pan pan;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private BankAccount bankAccount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pan getPan() {
		return pan;
	}

	public void setPan(Pan pan) {
		this.pan = pan;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}


