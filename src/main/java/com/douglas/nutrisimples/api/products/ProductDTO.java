package com.douglas.nutrisimples.api.products;

import java.math.BigDecimal;

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
}
