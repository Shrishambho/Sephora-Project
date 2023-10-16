package com.sephora.service;

import java.util.List;

import com.sephora.exception.AddressException;
import com.sephora.exception.CustomerException;
import com.sephora.model.Address;

public interface AddressService  {

	public Address addAddress(Address address,Integer customerId) throws CustomerException;
	
	public Address getAddressByAddressId(Integer addressId)throws AddressException;
	
	public List<Address> getAddressByCustomerId(Integer customerId) throws CustomerException;
}
