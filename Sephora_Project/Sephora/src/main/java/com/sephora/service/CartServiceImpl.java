package com.sephora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sephora.exception.CartException;
import com.sephora.exception.ProductException;
import com.sephora.model.Cart;
import com.sephora.model.Product;
import com.sephora.repository.CartRepository;
import com.sephora.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository; 
	
	@Autowired
	private ProductRepository productRepository;
	
	public void createCart(Cart cart) {
		
		cartRepository.save(cart);
	}


	@Override
	public Cart addProductToCart(Integer productId,Integer cartId) throws CartException,ProductException {
		
		log.info("Inside addProductToCart method of CartServiceImpl");
		Optional<Cart> cart = cartRepository.findById(cartId);
		
		if(cart.isEmpty()) {
			log.error("Throwing exception from addProductToCart method of CartServiceImpl.");
			throw new CartException("Cart with given id is not present.");
		}
		Optional<Product> product = productRepository.findById(productId);
		
		if(product.isEmpty()) {
			log.error("Throwing exception from addProductToCart method of CartServiceImpl.");
			throw new ProductException("Product with given id is not present.");
		}
		
		Cart crt = cart.get();
		Product prt = product.get();
		
		crt.getProducts().add(prt);
		prt.getCarts().add(crt);
		
		Cart updatedcart = cartRepository.save(crt);
		
		log.debug("Returning cart object from addProductToCart method of CartServiceImpl.");
		return updatedcart;
	}


	@Override
	public Cart getCartById(Integer cartId) throws CartException {
		log.info("Inside getCartById method of CartServiceImpl");
		
		Optional<Cart> cart = cartRepository.findById(cartId);
		
		if(cart.isPresent()) {
			 Cart crt = cart.get();
			 
			 
	    log.debug("Returning cart object from getCartById method of CartServiceImpl.");
			 return crt;
		}
		else {
			
			log.error("Throwing exception from getCartById method of CartServiceImpl.");
			
			throw new CartException("Cart with given id is not present.");
		}
		
	}


	@Override
	public List<Cart> getAllCarts() throws CartException {
		log.info("Inside getAllCarts method of CartServiceImpl.");
		
		List<Cart> list = cartRepository.findAll();
		
		log.debug("Returning list of object from getAllCarts method of CartServiceImpl.");
		
		return list;
	}

	
}
