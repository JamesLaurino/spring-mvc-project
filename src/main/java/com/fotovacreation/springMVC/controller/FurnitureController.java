package com.fotovacreation.springMVC.controller;

import com.fotovacreation.springMVC.model.FurnitureEntity;
import com.fotovacreation.springMVC.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FurnitureController
{

    @Autowired
    private FurnitureService furnitureService;

    @GetMapping("/furniture/{id}")
    public String getOneById(@PathVariable("id") int furnitureId,
                             Model model)
    {
        FurnitureEntity furnitureEntity = furnitureService.getById(furnitureId);
        model.addAttribute("furnitureEntity", furnitureEntity);
        return "furniture-details";
    }


    @GetMapping("/furniture")
    public String listPageableFurniture(Model model,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "5") int size) {

        Page<FurnitureEntity> furniturePage = furnitureService.getAllWithPage(page,size);
        model.addAttribute("furniturePage", furniturePage);

        // Pagination details
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", furniturePage.getTotalPages());
        model.addAttribute("totalItems", furniturePage.getTotalElements());

        return "furniture";
    }
}