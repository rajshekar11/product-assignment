package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.model.Product;

@Service
public class ProductDaoImpl implements ProductService {
	
	@Autowired
	private ProductRepo pRepo;

	@Override
	public Product registerProduct(Product p) throws ProductException {
		Product savedP= pRepo.save(p);
		if(savedP==null) {
			throw new ProductException("Product not registered");
		}
		
		return savedP;
	}

}
