package com.fotovacreation.springMVC.service;

import com.fotovacreation.springMVC.model.ProductDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceMock
{
    List<ProductDto> productDtos = new ArrayList<ProductDto>(
            Arrays.asList(
            new ProductDto(1,"Pomme"),
            new ProductDto(2,"Peche"),
            new ProductDto(3,"Poire"))
    );


    public List<ProductDto> getAllProducts()
    {
        return productDtos;
    }

    public String deleteProduct(int id)
    {
        ProductDto productDto = productDtos.remove(id-1);
        return "Product removed";
    }

    public ProductDto updateProduct(int id, String nameUpdated)
    {
        getAllProducts().get(id - 1).setName(nameUpdated);
        ProductDto productDto = getProductsById(id - 1);
        return productDto;
    }

    public ProductDto getProductsById(int id)
    {
        return getAllProducts().get(id - 1);
    }
}
