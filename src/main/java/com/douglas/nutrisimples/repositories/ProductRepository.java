package com.douglas.nutrisimples.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.nutrisimples.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
