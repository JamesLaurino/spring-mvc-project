package com.fotovacreation.springMVC.service;

import com.fotovacreation.springMVC.model.ProductDto;

import java.util.List;

public interface InterfaceProduct
{
    List<ProductDto> getAllProducts();
    String deleteProduct(int id);
    ProductDto updateProduct(int id, String nameUpdated);
    ProductDto getProductsById(int id);
}
