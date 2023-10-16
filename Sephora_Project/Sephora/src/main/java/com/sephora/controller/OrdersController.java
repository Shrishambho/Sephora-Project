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

import com.sephora.model.Orders;
import com.sephora.model.OrdersData;
import com.sephora.service.OrdersService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@PostMapping("/orders/{customerId}")
	public ResponseEntity<Orders> placeOrder(@RequestBody  OrdersData ordersData,@PathVariable Integer customerId){
		
		log.info("Inside placeOrder method of OrdersController");
		
		Orders ord = ordersService.placeOrder(ordersData, customerId);
		
		log.debug("Returning order object from placeOrder method of OrdersController.");
		return new ResponseEntity<>(ord,HttpStatus.CREATED);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> getAllOrders(){
		log.info("Inside getAllOrders method of OrdersController.");
		
		List<Orders> orders = ordersService.getAllOrders();
		
		log.debug("Returning list of orders from getAllOrders method of OrdersController.");
		return new ResponseEntity<>(orders,HttpStatus.CREATED);
	}
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<Orders> getOrderById(@PathVariable Integer orderId){
		log.info("Inside getOrderById method of OrdersController");
		Orders orders = ordersService.findbyOrderId(orderId);
		
		log.debug("Returning orders object from getOrderById method of OrdersController");
		return new ResponseEntity<>(orders,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/orders/customer/{customerId}")
	public ResponseEntity<List<Orders>> getOrderByCustomerId(@PathVariable Integer customerId){
		log.info("Inside getOrderByCustomerId method of OrdersController");
		
		List<Orders> orderList = ordersService.getOrderByCustomerId(customerId);
		
		log.debug("Returning list of orders from getOrderByCustomerId method of OrdersController.");
		return new ResponseEntity<>(orderList,HttpStatus.ACCEPTED);
	}
}
