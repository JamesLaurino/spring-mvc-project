package com.fotovacreation.springMVC.repository;

import com.fotovacreation.springMVC.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
