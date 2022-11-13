package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.service.ProductService;

@RestController
public class MyController {
	
	@Autowired
	private ProductService pService;
	
	
	@PostMapping("/products")
	public ResponseEntity<Product> registerProduct(@RequestBody Product p) throws ProductException{
		Product savedp= pService.registerProduct(p);
		
		return new ResponseEntity<Product>(savedp,HttpStatus.CREATED);
	}
	
}
