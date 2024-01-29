package com.douglas.nutrisimples.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.nutrisimples.model.Classification;

public interface ClassificationRepository extends JpaRepository<Classification, Long>{
}
