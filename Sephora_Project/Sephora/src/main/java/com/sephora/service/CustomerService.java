package com.sephora.service;

import java.util.List;

import com.sephora.exception.CustomerException;
import com.sephora.model.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);
	
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException;
	
	public List<Customer> getAllCustomer();
	
	public String deleteCustomer(Integer Customerid) throws CustomerException;
}
