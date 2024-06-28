package com.sp.beans;

import javax.persistence.Entity;

import jakarta.persistence.Column;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity
@Entity
@Table(name="account_details_user")
public class Account {
	@Id
	@Column(name="acc_num")
	private int acc_num;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="balance")
	private Long balance;
	
	@Column(name="balance")
	private String city;
	
	public int getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(int acc_num) {
		this.acc_num = acc_num;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
