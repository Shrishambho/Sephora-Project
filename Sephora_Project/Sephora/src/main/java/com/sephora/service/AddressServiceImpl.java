package com.sephora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sephora.exception.AddressException;
import com.sephora.exception.CustomerException;
import com.sephora.model.Address;
import com.sephora.model.Customer;
import com.sephora.repository.AddressRepository;
import com.sephora.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressrepository;
	
	
	@Override
	public Address addAddress(Address address,Integer customerId) throws CustomerException {
		
		log.info("Inside addAddress method of AddressServiceImpl");
		
		Optional<Customer> customer = customerRepository.findById(customerId);
		
		if(customer.isPresent()) {
			
            Customer cst = customer.get();
			
//			cst.getAddresses().add(address);
			address.setCustomer(cst);
			
			Address savedAddress = addressrepository.save(address);
			
			cst.getAddresses().add(savedAddress);
			
			customerRepository.save(cst);
			
			log.debug("Returning Address object from addAddress method of AddressServiceImpl");
			return savedAddress;
		}
		else {
			
			log.error("Throwing exception from addAddress method of AddressServiceImpl.");
			throw new CustomerException("Customer with given id is not present");
		}
		
		
		
	}


	@Override
	public Address getAddressByAddressId(Integer addressId) throws AddressException {
	
		log.info("Inside getAddressByAddressId method of AddressServiceImpl");
		Optional<Address> opt = addressrepository.findById(addressId);
		
		if(opt.isPresent()) {
			
			Address address = opt.get();
			
			log.debug("Returning Address object from getAddressByAddressId method of AddressServiceImpl");
			return address;
		}
		else {
			
			log.error("Throwing exception from getAddressByAddressId method of AddressServiceImpl.");
			throw new AddressException("No address with given id present");
		}
	}


	@Override
	public List<Address> getAddressByCustomerId(Integer customerId) throws CustomerException {
		
		log.info("Inside getAddressByCustomerId method of AddressServiceImpl");
		List<Address> list = addressrepository.findByCustomerCustomerId(customerId);
		
		log.debug("Returning list of Address object from getAddressByCustomerId method of AddressServiceImpl");
		return list;
	}
	
	

}
