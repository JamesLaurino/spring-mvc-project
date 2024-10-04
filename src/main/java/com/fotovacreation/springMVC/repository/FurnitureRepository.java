package com.fotovacreation.springMVC.repository;

import com.fotovacreation.springMVC.model.FurnitureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<FurnitureEntity,Integer>
{

}
