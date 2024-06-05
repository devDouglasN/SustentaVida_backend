package com.douglas.nutrisimples.api.classifications;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.nutrisimples.domain.Classification;

public interface ClassificationRepository extends JpaRepository<Classification, Long>{
}
