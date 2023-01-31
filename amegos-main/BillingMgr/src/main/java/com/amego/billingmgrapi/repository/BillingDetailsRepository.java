package com.amego.billingmgrapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amego.billingmgrapi.entity.BillingDetails;

@Repository
public interface BillingDetailsRepository extends JpaRepository<BillingDetails, Long> {
	List<BillingDetails> findByAmego(String amego);
}
