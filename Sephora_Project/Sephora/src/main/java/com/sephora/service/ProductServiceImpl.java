package com.sephora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sephora.exception.ProductException;
import com.sephora.model.Product;
import com.sephora.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {
		
		log.info("Inside addProduct method of ProductServiceImpl.");
		
		Product savedProduct = productRepository.save(product);
		
		
		log.debug("Returning product object from addProduct method of ProductServiceImpl.");
		return savedProduct;
	}

	@Override
	public Product updateProductPrice(Integer productId, double price) throws ProductException {
		
		log.info("Inside updateProductPrice method of ProductServiceImpl.");
		if(price<=0) {
			
			log.error("Throwing exception from updateProductPrice method of ProductServiceImpl.");
			
			throw new ProductException("Product price can not be less than or equal to zero.");
		}
		Optional<Product> product = productRepository.findById(productId);
		
		if(product.isPresent()) {
			Product pro= product.get();
			
			pro.setPrice(price);
			
			Product updatedProduct = productRepository.save(pro);
			return updatedProduct;
			
		}
		else {
			
			log.error("Throwing exception from updateProductPrice method of ProductServiceImpl.");
			
			throw new ProductException("Product with given id is not present.");
		}
		
	}

	@Override
	public Product updateProductQuantity(Integer productId, Integer quantity) throws ProductException {
		log.info("Inside updateProductQuantity method of ProductServiceImpl.");
		
		
		if(quantity<0) {
			
			log.error("Throwing exception from updateProductQuantity method of ProductServiceImpl.");
			
			throw new ProductException("Product quantity can not be less than zero.");
		}
		Optional<Product> product = productRepository.findById(productId);
		
		if(product.isPresent()) {
			Product pro= product.get();
			
			pro.setQuantity(quantity);
			
			
			Product updatedProduct = productRepository.save(pro);
			
			log.debug("Returning product object from updateProductQuantity method of ProductServiceImpl.");
			return updatedProduct;
			
		}
		else {
			
			log.error("Throwing exception from updateProductQuantity method of ProductServiceImpl.");
			throw new ProductException("Product with given id is not present.");
		}
	}

	@Override
	public String deleteProduct(Integer productId) throws ProductException {
		
		log.info("Inside deleteProduct method of ProductServiceImpl.");
		
		
		Optional<Product> product = productRepository.findById(productId);
		
		if(product.isPresent()) {
			productRepository.delete(product.get());
			
			log.debug("Returning status of deleted product from deleteProduct method of ProductServiceImpl.");
			return "Product deleted Successfully.";
		}
		else {
			
			log.error("Throwing exception from deleteProduct method of ProductServiceImpl.");
			throw new ProductException("Product with given id is not present.");
		}
		
	}

	@Override
	public List<Product> getAllProducts() {
		log.info("Inside getAllProducts method of ProductServiceImpl.");
		
		List<Product> productList = productRepository.findAll();
		
		log.debug("Returning list of products from getAllProducts method of ProductServiceImpl.");
		return productList;
	}

	@Override
	public List<Product> getProdctPageWise(Integer pageNumber, Integer size) {
		log.info("Inside getProdctPageWise method of ProductServiceImpl.");
		
		Pageable pageable = PageRequest.of(pageNumber-1, size,Sort.by("price").ascending());
		
		List<Product> list = productRepository.findAll(pageable).getContent();
		
		log.debug("Returning list of products from getProdctPageWise method of ProductServiceImpl.");
		
		return list;
	}

}
