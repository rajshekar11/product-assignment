package com.masai.service;


import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.model.Product;

public interface ProductService {

	public Product registerProduct(Product p)throws ProductException;
	
}
