package com.fotovacreation.springMVC.service.mapper;

import com.fotovacreation.springMVC.model.ProductDto;
import com.fotovacreation.springMVC.model.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductMapper
{
    public ProductDto entityToDto(ProductEntity productEntity)
    {
        return ProductDto.builder()
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .build();
    }

    public ProductEntity dtoToEntity(ProductDto productDto)
    {
        return ProductEntity.
                builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build();
    }

    public List<ProductDto> entitiesToDtos(List<ProductEntity> productEntities)
    {
        List<ProductDto> productDtos = new ArrayList<>();
        for(ProductEntity entity : productEntities)
        {
            ProductDto productDto = new ProductDto();
            productDto.setName(entity.getName());
            productDto.setPrice(entity.getPrice());
            productDtos.add(productDto);
        }

        return productDtos;
    }
}
