package com.amego.billingmgrapi.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "forexrate")
@EntityListeners(AuditingEntityListener.class)
public class ForexRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
		
	private String currency_from;
	private String currency_to;
	private Long rate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCurrency_from() {
		return currency_from;
	}
	public void setCurrency_from(String currency_from) {
		this.currency_from = currency_from;
	}
	public String getCurrency_to() {
		return currency_to;
	}
	public void setCurrency_to(String currency_to) {
		this.currency_to = currency_to;
	}
	public Long getRate() {
		return rate;
	}
	public void setRate(Long rate) {
		this.rate = rate;
	}
}
