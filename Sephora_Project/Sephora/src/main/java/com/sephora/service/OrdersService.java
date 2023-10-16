package com.sephora.service;

import java.util.List;

import com.sephora.exception.CustomerException;
import com.sephora.exception.OrdersException;
import com.sephora.exception.ProductException;
import com.sephora.model.Orders;
import com.sephora.model.OrdersData;

public interface OrdersService {

	
	public Orders placeOrder(OrdersData ordersData,Integer customerId)throws CustomerException,OrdersException,ProductException;
	
	public List<Orders> getAllOrders();
	
	public Orders findbyOrderId(Integer orderId) throws OrdersException;
	
	public List<Orders> getOrderByCustomerId(Integer customerId)throws CustomerException;
	
	
	
	
}
