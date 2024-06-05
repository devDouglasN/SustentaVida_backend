package com.douglas.nutrisimples.api.products;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.douglas.nutrisimples.domain.Product;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
		
	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<Product> list = productService.findAll();
		List<ProductDTO> listDto = list.stream().map(ProductDTO::new).collect(Collectors.toList());
	    return ResponseEntity.ok().body(listDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
		Product product = productService.findById(id);
		return ResponseEntity.ok().body(new ProductDTO(product));
	}	
	
	@PostMapping
	public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO objectDTO) {
		Product newObj = productService.create(objectDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductDTO(newObj));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO objectDTO) {
	    Product newObj = productService.update(id, objectDTO);
	    return ResponseEntity.ok().body(new ProductDTO(newObj));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
	    return productService.deleteById(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
}
