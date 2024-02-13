package com.douglas.nutrisimples.api.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.nutrisimples.domain.Product;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "", allowedHeaders = "")
public class ProductController {
		
	@Autowired
	public ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.ok().body(productService.findAll());
	}	
}
