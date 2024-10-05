package com.fotovacreation.springMVC.controller;

import com.fotovacreation.springMVC.model.CategoryEntity;
import com.fotovacreation.springMVC.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController
{

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/form")
    public String showRegistrationForm(Model model) {

        CategoryEntity categoryEntity = new CategoryEntity();
        model.addAttribute("categoryEntity",categoryEntity);

        return "category-form";
    }

    @GetMapping("/category")
    public String getAllCategory(Model model) {

        List<CategoryEntity> categoryEntities = categoryService.getAll();
        model.addAttribute("categoryEntities",categoryEntities);
        return "category";
    }


    @PostMapping("/category/form")
    public String submitRegistrationForm(
            @Valid @ModelAttribute("categoryEntity") CategoryEntity categoryEntity,
            BindingResult bindingResult,
            Model model)
    {

        if (bindingResult.hasErrors())
        {
            return "category-form";
        }

        return "product";

    }
}
