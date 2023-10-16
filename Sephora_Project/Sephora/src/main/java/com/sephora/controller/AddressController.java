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

import com.sephora.model.Address;
import com.sephora.service.AddressService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/address/{customerId}")
	public ResponseEntity<Address> addAddress(@RequestBody @Valid Address address,@PathVariable Integer customerId){
		
		log.info("Inside addAddress method of AddressController");
		Address savedAddress = addressService.addAddress(address, customerId);
		
		log.debug("Returning savedAddress object from AddressController");
		return new ResponseEntity<>(savedAddress,HttpStatus.CREATED);
	}
	
	@GetMapping("/address/{addressId}")
     public ResponseEntity<Address> getAddressById(@PathVariable Integer addressId){
		
		log.info("Inside getAddressById of AddressController");
		Address savedAddress = addressService.getAddressByAddressId(addressId);
		
		log.debug("Returning object of address from getAddressById of AddressController");
		return new ResponseEntity<>(savedAddress,HttpStatus.CREATED);
	}
	
	@GetMapping("/addressOfCustomer/{customerId}")
    public ResponseEntity<List<Address>> getAddressByCustomerId(@PathVariable Integer customerId){
		
		log.info("Inside getAddressByCustomerId method of AddressController");
		List<Address> savedAddress = addressService.getAddressByCustomerId(customerId);
		
		log.debug("Returning list of addresses from getAddressByCustomerId method of AddressController");
		return new ResponseEntity<>(savedAddress,HttpStatus.CREATED);
	}
	
}
