package com.sephora.service;

import java.util.List;

import com.sephora.exception.ProductException;
import com.sephora.model.Product;

public interface ProductService {

	public Product addProduct(Product product);
	
	public Product updateProductPrice(Integer productId,double price) throws ProductException;
	
	public Product updateProductQuantity(Integer productId,Integer quantity) throws ProductException;

	public String deleteProduct(Integer productId) throws ProductException;
	
	public List<Product> getAllProducts();
	
	public List<Product> getProdctPageWise(Integer pageNumber,Integer size);
}
