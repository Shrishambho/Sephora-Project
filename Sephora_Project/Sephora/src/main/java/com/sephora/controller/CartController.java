package com.sephora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sephora.model.Cart;
import com.sephora.service.CartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PatchMapping("/cart/{cartId}/{productId}")
	public ResponseEntity<Cart> addProductToCart(@PathVariable Integer productId,@PathVariable Integer cartId){
		log.info("Inside addProductToCart method of CartController");
		
		Cart cart = cartService.addProductToCart(productId,cartId);
		
		log.debug("Returning cart object from addProductToCart method of CartController");
		return new ResponseEntity<>(cart,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cart/{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable Integer cartId){
		
		log.info("Inside getCartById method of CartController");
		Cart cart = cartService.getCartById(cartId);
		
		log.debug("Returning cart object from getCartById method of CartController");
		return new ResponseEntity<>(cart,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/cart")
	public ResponseEntity<List<Cart>> getAllCarts(){
		log.info("Inside getAllCarts method of CartController");
		List<Cart> list = cartService.getAllCarts();
		
		log.debug("Returning list of cart object from getAllCarts method of CartController");
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
