package com.amego.billingmgrapi.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "billingdetails")
@EntityListeners(AuditingEntityListener.class)
public class BillingDetails {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String amego;	
	private String description;
	private Long amount;
	private String currency;
	private String amegosharedet;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAmego() {
		return amego;
	}
	public void setAmego(String amego) {
		this.amego = amego;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmegosharedet() {
		return amegosharedet;
	}
	public void setAmegosharedet(String amegosharedet) {
		this.amegosharedet = amegosharedet;
	}
}
