package com.sephora.service;

import java.util.List;

import com.sephora.exception.CartException;
import com.sephora.exception.ProductException;
import com.sephora.model.Cart;

public interface CartService {

	public void createCart(Cart cart);
	
	public Cart addProductToCart(Integer productId,Integer cartId) throws CartException,ProductException;
	
	public Cart getCartById(Integer cartId) throws CartException;
	
	public List<Cart> getAllCarts()throws CartException;
	
	
	
	
	
	
}
