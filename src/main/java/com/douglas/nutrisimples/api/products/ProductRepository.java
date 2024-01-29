package com.douglas.nutrisimples.api.products;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.nutrisimples.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
