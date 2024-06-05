package com.douglas.nutrisimples.api.category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.nutrisimples.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
