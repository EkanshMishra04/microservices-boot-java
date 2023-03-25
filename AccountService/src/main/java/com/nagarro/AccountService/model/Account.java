package com.nagarro.AccountService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.nagarro.AccountService.dto.CustomerDto;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aid;
	private Integer cid;
	private Long balance;
	@Transient
	private CustomerDto customerDetail;
	
	
	
	public CustomerDto getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDto customerDetail) {
		this.customerDetail = customerDetail;
	}

	public Account() {
		
	}

	public Account(Integer cid, Long balance) {
		this.cid = cid;
		this.balance = balance;
	}
	
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}

	
	
	
}
