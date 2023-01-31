package com.amego.billingmgrapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amego.billingmgrapi.entity.ForexRate;

@Repository
public interface ForexRateRepository extends JpaRepository<ForexRate, Long>{

}
