package com.douglas.nutrisimples.api.products;

import java.math.BigDecimal;

import com.douglas.nutrisimples.domain.Product;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record ProductDTO(
		
	    Long id,
	    
	    @NotBlank(message = "Name cannot be blank") 
	    @Size(max = 100, message = "Name cannot have more than 100 characters") 
	    String name,
	    
	    @NotNull(message = "Price cannot be null") @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero") 
	    BigDecimal price,
	    
	    @NotNull(message = "Amount cannot be null") @Min(value = 0, message = "Amount cannot be less than zero") 
	    Integer amount,
	    
	    @Size(max = 200, message = "Description cannot have more than 200 characters") 
	    String description
	) {
	    public ProductDTO(Product obj) {
	        this(
	            obj.getId(),
	            obj.getName(),
	            obj.getPrice(),
	            obj.getAmount(),
	            obj.getDescription()
	        );
	    }
	}
