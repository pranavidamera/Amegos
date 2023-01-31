package com.amego.billingmgrapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
//@ComponentScan(basePackages = { "com.amego.billingmgrapi" })
//@EnableJpaRepositories(basePackages = {"repository"})
//@EntityScan("com.amego.billingmgrapi.entity.*") 
public class BillingMgrApplication {
	public static void main(String[] args) {
		SpringApplication.run(BillingMgrApplication.class, args);
	}
}
