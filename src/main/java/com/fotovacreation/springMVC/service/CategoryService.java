package com.fotovacreation.springMVC.service;

import com.fotovacreation.springMVC.model.CategoryEntity;
import com.fotovacreation.springMVC.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> getAll()
    {
        return categoryRepository.findAll();
    }

}