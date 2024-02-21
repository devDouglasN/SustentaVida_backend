package com.douglas.nutrisimples.api.products;

import java.util.List;
import java.util.Optional;

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
	
	public Product findById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product.orElseThrow(() -> new RuntimeException("Object not found! ID:" + id));
	}
	
	public Product create(ProductDTO objectDTO) {
		objectDTO.setId(null);
		Product newObj = new Product(objectDTO);
	    return productRepository.save(newObj);
	}
	
	public Product update(Long id, ProductDTO objectDTO) {
	    Product obj = findById(id);
	    obj.setName(objectDTO.getName());
	    obj.setPrice(objectDTO.getPrice());
	    return productRepository.save(obj);
	}
}
