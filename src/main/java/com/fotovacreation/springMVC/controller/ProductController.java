package com.fotovacreation.springMVC.controller;

import com.fotovacreation.springMVC.model.ProductDto;
import com.fotovacreation.springMVC.service.ProductService;
import com.fotovacreation.springMVC.service.ProductServiceMock;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController
{
    @Autowired
    private ProductServiceMock productServiceMock;

    @Autowired
    private ProductService productService;

    /* GET PRODUCT */
    @GetMapping("/product")
    public String getAllProduct(Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        List<ProductDto> productDtos = productService.getAllProducts();
        model.addAttribute("products", productDtos);
        model.addAttribute("userDetails", userDetails);

        return "product";
    }

    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable("id") int productId, Model model)
    {
        ProductDto productDto = productServiceMock.getProductsById(productId);
        model.addAttribute("productDto", productDto);
        return "product-details";
    }

    /* ADD PRODUCT */
    @GetMapping("/product/form")
    public String formProduct(Model model)
    {
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto",productDto);
        return "form-product";
    }

    @PostMapping("/product/add")
    public String addProduct(
            @Valid @ModelAttribute("productDto") ProductDto productDto,
            BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "redirect:/product/error";
        }
        productService.insertProduct(productDto);
        return "redirect:/product";
    }

    /* DELETE PRODUCT */
    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable("id") int productId,
                                Model model)
    {
        String res = productServiceMock.deleteProduct(productId);
        model.addAttribute("response", res);
        return "delete-product";
    }

    /* UPDATE PRODUCT */
    @PutMapping("/product/{id}/{name}")
    public String updateProduct(@PathVariable("id") int productId,
                                @PathVariable("name") String name,
                                Model model)
    {
        ProductDto productDto = productServiceMock.updateProduct(productId,name);
        model.addAttribute("productDto", productDto);
        return "update-product";
    }

    /* ERROR MESSAGE */
    @GetMapping("/product/error")
    public String errorProduct(Model model)
    {
        return "error-product";
    }
}
