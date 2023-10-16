package com.sephora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sephora.model.Product;
import com.sephora.service.ProductService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//Add product
	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product){
		
		log.info("Inside addProduct method of ProductController.");
		Product savedProduct = productService.addProduct(product);
		
		log.debug("Returning saved object of product from addProduct method of ProductController.");
		return new ResponseEntity<>(savedProduct,HttpStatus.ACCEPTED);
	}
	
	
	//Update price.
	@PatchMapping("/productPrice/{productId}/{price}")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,@PathVariable double price ){
		log.info("Inside updateProduct method of ProductController.");
		Product product = productService.updateProductPrice(productId, price);
		
		log.debug("Returning product object from addProduct method of ProductController.");
		return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
	}
	
	//Update quantity
	@PatchMapping("/productQuantity/{productId}/{quantity}")
	public ResponseEntity<Product> updateQuantity(@PathVariable Integer productId,@PathVariable Integer quantity ){
		log.info("Inside updateQuantity method of ProductController.");
		Product product = productService.updateProductQuantity(productId, quantity);
		
		log.debug("Returning product object from updateQuantity method of ProductController.");
		return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
	}
	
	
	//Delete product
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer productId){
		log.info("Inside deleteProduct method of ProductController.");
		String result = productService.deleteProduct(productId );
		
		log.debug("Returning status of deleted product from deleteProduct method of ProductController.");
		return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	
	
	//Get All Product
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProducts(){
		log.info("Inside getAllProducts method of ProductController.");
		List<Product> listOfProducts = productService.getAllProducts();
		
		log.debug("Returning product list from getAllProducts method of ProductController.");
		return new ResponseEntity<>(listOfProducts,HttpStatus.ACCEPTED);
	}
	
	
	//Get product page wise.
	
	@GetMapping("/product/{pageNumber}/{size}")
	public ResponseEntity<List<Product>> getProductPageWise(@PathVariable Integer pageNumber,@PathVariable Integer size ){
		log.info("Inside getProductPageWise method of ProductController.");
		List<Product> list = productService.getProdctPageWise(pageNumber, size);
		
		log.debug("Returning product list from getProductPageWise method of ProductController.");
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
