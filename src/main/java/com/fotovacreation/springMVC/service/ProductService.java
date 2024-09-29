package com.fotovacreation.springMVC.service;

import com.fotovacreation.springMVC.model.ProductDto;
import com.fotovacreation.springMVC.repository.ProductRepository;
import com.fotovacreation.springMVC.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDto> getAllProducts()
    {
        return productMapper.entitiesToDtos(productRepository.findAll());
    }

    public String insertProduct(ProductDto productDto)
    {
        productRepository.save(productMapper.dtoToEntity(productDto));
        return "insertion ok";
    }

}
