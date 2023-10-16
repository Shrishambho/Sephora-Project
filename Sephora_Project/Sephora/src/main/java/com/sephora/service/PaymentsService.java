package com.sephora.service;

import java.util.List;

import com.sephora.exception.CustomerException;
import com.sephora.exception.OrdersException;
import com.sephora.model.Payments;

public interface PaymentsService {

	public Payments makePayment(Payments payment,Integer customerId,Integer orderId)throws CustomerException,OrdersException;

	public List<Payments> getAllPayments();




}
