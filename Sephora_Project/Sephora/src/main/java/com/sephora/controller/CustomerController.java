package com.sephora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sephora.model.Cart;
import com.sephora.model.Customer;
import com.sephora.service.CartService;
import com.sephora.service.CustomerService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CartService cartService;
	
	//Post mapping
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody @Valid Customer customer){
		
		log.info("Inside saveCustomerHandler of CustomerController");
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		
		customer.setRole("ROLE_"+customer.getRole().toUpperCase());
		
		
		Customer registeredCustomer= cService.saveCustomer(customer);
		 
		Cart cart= new Cart();
		
		cart.setCustomer(registeredCustomer);
		
		cartService.createCart(cart);
		
		log.debug("returning customer object from saveCustomerHandler of CustomerController");
		return new ResponseEntity<>(registeredCustomer,HttpStatus.ACCEPTED);
		
	}
	
	
	//Get Mapping
	
	
	@GetMapping("/signIn")
	public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth){
		log.info("Inside getLoggedInCustomerDetailsHandler of CustomerController");
		System.out.println(auth); // this Authentication object having Principle object details
		
		 Customer customer= cService.getCustomerDetailsByEmail(auth.getName());
		 
		 log.debug("returning customer object from getLoggedInCustomerDetailsHandler of CustomerController");
		 return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
	}
	
	//Returning all customers
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		
		log.info("Inside getAllCustomers of CustomerController");
		List<Customer> list = cService.getAllCustomer();
		
		log.debug("returning list of customer object from getAllCustomers of CustomerController");
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	
	//delete mapping
	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId){
		log.info("Inside deleteCustomer of CustomerController");
		String result = cService.deleteCustomer(customerId);
		
		log.debug("returning status of deleted customer from saveCustomerHandler of CustomerController");
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	
}
