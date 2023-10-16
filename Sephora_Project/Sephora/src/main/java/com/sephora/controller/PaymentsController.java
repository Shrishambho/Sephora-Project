package com.sephora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sephora.model.Payments;
import com.sephora.service.PaymentsService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentsController {

	@Autowired
	private PaymentsService paymentsService;
	
	@PostMapping("/payments/{customerId}/orders/{orderId}")
	public ResponseEntity<Payments> makePayment(@RequestBody @Valid Payments payments,@PathVariable Integer customerId,
			@PathVariable Integer orderId){
		
		log.info("Inside makePayment of PaymentsController.");
		Payments pyt = paymentsService.makePayment( payments,customerId,orderId);
		
		log.debug("Returning payment object from makePayment of PaymentsController.");
		return new ResponseEntity<>(pyt,HttpStatus.CREATED);
	}
	
	@GetMapping("/payments")
	public ResponseEntity<List<Payments>> getAllPayments(){
		log.info("Inside getAllPayments of PaymentsController.");
		List<Payments> list = paymentsService.getAllPayments();
		
		log.debug("Returning list of payments makePayment of PaymentsController.");
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
}
