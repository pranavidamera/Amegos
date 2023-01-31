package com.amego.billingmgrapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amego.billingmgrapi.entity.Amegos;
import com.amego.billingmgrapi.entity.BillingDetails;
import com.amego.billingmgrapi.exception.ResourceNotFoundException;
import com.amego.billingmgrapi.repository.AmegosRepository;
import com.amego.billingmgrapi.repository.BillingDetailsRepository;
import com.amego.billingmgrapi.repository.ForexRateRepository;

@RestController
@RequestMapping("/billingapi")
public class BillingController {

	@Autowired
	AmegosRepository amegosRepository;
	
	@Autowired
	BillingDetailsRepository billingDetailsRepository;
	
	@Autowired
	ForexRateRepository forexRateRepository;
		
	/* Amegos APIs */
	
	@GetMapping("/getAmegos") 
	   public List<Amegos> getAllAmegos() { 
		   return amegosRepository.findAll(); 
	 }
	
	@PostMapping("/createAmegos") 
   public Amegos createAmegos(@RequestBody Amegos amegos) { 
	   return amegosRepository.save(amegos); 
   }	
   
	@PutMapping("/updateAmegos/{id}")
	public Amegos updateAmegos(@PathVariable(value = "id") Long id, @RequestBody Amegos amegos) {

		Amegos amegosResp = amegosRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Amego", "id", id));
		
		amegosResp.setName(amegos.getName());
		amegosResp.setCountry(amegos.getCountry());
		amegosResp.setCurrency(amegos.getCurrency());
		Amegos updatedAmegos = amegosRepository.save(amegosResp);
		return updatedAmegos;
	}
	
	@DeleteMapping("/deleteAmegos/{id}")
	public ResponseEntity<?> deleteAmegos(@PathVariable(value = "id") Long id) {
		Amegos amegosResp = amegosRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Amego", "id", id));

		amegosRepository.delete(amegosResp);

		return ResponseEntity.ok().build();
	}
	
	/* Billing Details APIs */
	
   @GetMapping("/getBillList") 
   public List<BillingDetails> getAllBillDetails() { 
	   return billingDetailsRepository.findAll(); 
   }
   
   @GetMapping("/getBillListByAmego/{name}") 
   public List<BillingDetails> getAllBillDetailsByAmego(@PathVariable(value = "name") String name) { 
	   return billingDetailsRepository.findByAmego(name); 
   }
   
   @PostMapping("/createBillDetail") 
   public BillingDetails createBillingDetails(@RequestBody BillingDetails billingDetails) {
	   
	   List<Amegos> amegosList = amegosRepository.findAll();
	   int amegosCnt = amegosList.size();
	   int perShareAmt = (int) (billingDetails.getAmount()/amegosCnt);
	   String shareDetails = "";
	   
	   for(Amegos amegosDetails : amegosList) {
		  String name =  amegosDetails.getName();
		  shareDetails =  shareDetails +" /n"+ name + " = " + perShareAmt + amegosDetails.getCurrency()+" ";
	   }
	   billingDetails.setAmegosharedet(shareDetails);
	   return billingDetailsRepository.save(billingDetails); 
   }
   
   @PutMapping("/updateBillDetail/{id}")
	public BillingDetails updateBillingDetails(@PathVariable(value = "id") Long id, @RequestBody BillingDetails billingDetails) {

	   BillingDetails billingDetailsResp = billingDetailsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("BillingDetails", "id", id));
		
	   billingDetailsResp.setAmego(billingDetails.getAmego());
	   billingDetailsResp.setAmount(billingDetails.getAmount());
	   billingDetailsResp.setCurrency(billingDetails.getCurrency());
	   billingDetailsResp.setDescription(billingDetails.getDescription());
	   
	   BillingDetails updatedBillingDetails = billingDetailsRepository.save(billingDetailsResp);
		return updatedBillingDetails;
	}
   
   @DeleteMapping("/deleteBillDetail/{id}")
	public ResponseEntity<?> deleteBillDetail(@PathVariable(value = "id") Long id) {
	   BillingDetails billingDetailsResp = billingDetailsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("BillingDetails", "id", id));

	   billingDetailsRepository.delete(billingDetailsResp);

		return ResponseEntity.ok().build();
	}
   
}
