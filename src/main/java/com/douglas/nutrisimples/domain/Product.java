package com.douglas.nutrisimples.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_classification")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Please enter the product name!")
	@Size(min = 2, max = 80)
	private String name;
	
	@NotNull(message = "Price is mandatory!")
	@Positive(message = "The price must be greater than zero!")
	private BigDecimal price;
	
	@PositiveOrZero(message = "The quantity must be greater than or equal to 0!")
	private Integer amount;
	
	@Size(min = 10, max = 250)
	private String description;
	
	@ManyToOne
	@JsonIgnoreProperties("product")
	private Classification classification;
		
}
