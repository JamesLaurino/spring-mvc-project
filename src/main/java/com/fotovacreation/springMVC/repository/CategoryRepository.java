package com.fotovacreation.springMVC.repository;

import com.fotovacreation.springMVC.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
