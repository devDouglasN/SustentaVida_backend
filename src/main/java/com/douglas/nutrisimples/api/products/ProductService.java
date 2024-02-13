package com.douglas.nutrisimples.api.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.nutrisimples.domain.Product;

@Service
public class ProductService {
	
	@Autowired
	public ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}
}
