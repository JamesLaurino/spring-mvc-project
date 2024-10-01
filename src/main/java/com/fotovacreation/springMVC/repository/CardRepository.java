package com.fotovacreation.springMVC.repository;

import com.fotovacreation.springMVC.model.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity, Integer> {
}
