package com.sephora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sephora.exception.CustomerException;
import com.sephora.model.Customer;
import com.sephora.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository cRepository;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		log.info("Inside saveCustomer method of CustomerServiceImpl");
		
		log.debug("Returning customer object from saveCustomer method of CustomerServiceImpl.");
		return cRepository.save(customer);
		
	}

	@Override
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException {
        log.info("Inside getCustomerDetailsByEmail method of CustomerServiceImpl");
		
		log.debug("Returning customer object from getCustomerDetailsByEmail method of CustomerServiceImpl.");
		
		return cRepository.findByEmail(email).orElseThrow(() -> new CustomerException("Customer Not found with Email: "+email));
	}

	@Override
	public List<Customer> getAllCustomer() {
		log.info("Inside getAllCustomer method of CustomerServiceImpl");
		List<Customer> list = cRepository.findAll();
		
		log.debug("Returning list of customer object from getAllCustomer method of CustomerServiceImpl.");
		return list;
	}

	@Override
	public String deleteCustomer(Integer Customerid) throws CustomerException {
		log.info("Inside deleteCustomer method of CustomerServiceImpl");
		Optional<Customer> cust = cRepository.findById(Customerid);
		
		if(cust.isPresent()) {
			Customer customer = cust.get();
			
			cRepository.delete(customer);
			
			log.debug("Returning status of deleted customer from eleteCustomer method of CustomerServiceImpl");
			return "Customer deleted Successfully";
		}
		else {
			
			log.error("Throwing exception from deleteCustomer method of CustomerServiceImpl.");
			throw new CustomerException("Customer with given id not present");
		}
		
	}

}
