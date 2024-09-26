package com.fotovacreation.springMVC.controller;

import com.fotovacreation.springMVC.model.ProductDto;
import com.fotovacreation.springMVC.repository.ProductRepository;
import com.fotovacreation.springMVC.service.ProductService;
import com.fotovacreation.springMVC.service.ProductServiceMock;
import com.fotovacreation.springMVC.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class ProductController
{
    @Autowired
    private ProductServiceMock productServiceMock;

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String getAllProduct(Model model)
    {
        List<ProductDto> productDtos = productService.getAllProducts();
        model.addAttribute("products", productDtos);
        return "product";
    }

    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable("id") int productId, Model model)
    {
        ProductDto productDto = productServiceMock.getProductsById(productId);
        model.addAttribute("productDto", productDto);
        return "product-details";
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable("id") int productId,
                                Model model)
    {
        String res = productServiceMock.deleteProduct(productId);
        model.addAttribute("response", res);
        return "delete-product";
    }

    @PutMapping("/product/{id}/{name}")
    public String updateProduct(@PathVariable("id") int productId,
                                @PathVariable("name") String name,
                                Model model)
    {
        ProductDto productDto = productServiceMock.updateProduct(productId,name);
        model.addAttribute("productDto", productDto);
        return "update-product";
    }
}
