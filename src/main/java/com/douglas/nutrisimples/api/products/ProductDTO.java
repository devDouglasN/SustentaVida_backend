package com.douglas.nutrisimples.api.products;

import java.math.BigDecimal;

import com.douglas.nutrisimples.domain.Product;

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
	private String name;
	private BigDecimal price;
	private Integer amount;
	private String description;
	
	public ProductDTO(Product obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.price = obj.getPrice();
		this.amount = obj.getAmount();
		this.description = obj.getDescription();
	}	
}
