package com.sephora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sephora.exception.CustomerException;
import com.sephora.exception.OrdersException;
import com.sephora.model.Customer;
import com.sephora.model.Orders;
import com.sephora.model.Payments;
import com.sephora.repository.CustomerRepository;
import com.sephora.repository.OrdersRepository;
import com.sephora.repository.PaymentsRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentsServiceImpl implements PaymentsService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrdersRepository ordersrepository;
	
	@Autowired
	private PaymentsRepository paymentsRepository;
	
	@Override
	public Payments makePayment(Payments payment, Integer customerId, Integer orderId)
			throws CustomerException, OrdersException {
		
		log.info("Inside makePayment method of PaymentsServiceImpl.");
		Optional<Customer> opt = customerRepository.findById(customerId);
		
		if(opt.isEmpty()) {
			log.error("Throwing exception from makePayment method of PaymentsServiceImpl.");
			throw new CustomerException("Customer with given id is not present");
		}
		
		Optional<Orders> opt1 = ordersrepository.findById(orderId);
		
		if(opt1.isEmpty()) {
			
			log.error("Throwing exception from makePayment method of PaymentsServiceImpl.");
			throw new OrdersException("No order with given id present");
			
		}
		
		Customer customer =opt.get();
		
		Orders orders=opt1.get();
		
		payment.setCustomer(customer);
		
		payment.setOrders(orders);
		
		Payments pyt = paymentsRepository.save(payment);
		
		customer.getPayments().add(pyt);
		
		customerRepository.save(customer);
		
		orders.setPayments(pyt);
		
		log.debug("Returning payment  object from makePayment method of PaymentsServiceImpl.");
		return pyt;
	}

	@Override
	public List<Payments> getAllPayments() {
		
		log.info("Inside getAllPayments method of PaymentsServiceImpl.");
		
		List<Payments> list = paymentsRepository.findAll();
		
		log.debug("Returning list of payments from getAllPayments method of PaymentsServiceImpl.");
		return list;
	}

}
