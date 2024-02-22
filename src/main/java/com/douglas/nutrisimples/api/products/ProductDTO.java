package com.douglas.nutrisimples.api.products;

import java.math.BigDecimal;

import com.douglas.nutrisimples.domain.Product;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductDTO {

	private Long id;
	
	@NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name cannot have more than 100 characters")
	private String name;
	
	@NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
	private BigDecimal price;
	
	@NotNull(message = "Amount cannot be null")
    @Min(value = 0, message = "Amount cannot be less than zero")
	private Integer amount;
	
	@Size(max = 200, message = "Description cannot have more than 200 characters")
	private String description;
	
	public ProductDTO(Product obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.price = obj.getPrice();
		this.amount = obj.getAmount();
		this.description = obj.getDescription();
	}	
}
