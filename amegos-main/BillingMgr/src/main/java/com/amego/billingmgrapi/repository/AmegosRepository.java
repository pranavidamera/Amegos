package com.amego.billingmgrapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amego.billingmgrapi.entity.Amegos;

@Repository
public interface AmegosRepository  extends JpaRepository<Amegos, Long> {

}
