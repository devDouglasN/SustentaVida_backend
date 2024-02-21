package com.douglas.nutrisimples.api.products;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.douglas.nutrisimples.domain.Product;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "", allowedHeaders = "")
public class ProductController {
		
	@Autowired
	public ProductService productService;
	
	public ResponseEntity<List<ProductDTO>> findall() {
		List<Product> list = productService.findAll();
		List<ProductDTO> listDto = list.stream().map(obj -> new ProductDTO(obj)).collect(Collectors.toList());
	    return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
		Product product = productService.findById(id);
		return ResponseEntity.ok().body(new ProductDTO(product));
	}	
	
	@PostMapping
	public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO objectDTO) {
		Product newObj = productService.create(objectDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
