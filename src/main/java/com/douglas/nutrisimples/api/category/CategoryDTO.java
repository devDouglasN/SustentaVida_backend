package com.douglas.nutrisimples.api.category;

import java.util.List;

import com.douglas.nutrisimples.domain.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record CategoryDTO(
	    Long id,
	    
	    @NotBlank 
	    @Size(min = 3, max = 70) 
	    String name,
	    
	    @NotBlank 
	    @Size(min = 15, max = 700) 
	    String description,
	    
	    List<Product> produtos
	    
	) {
	}
