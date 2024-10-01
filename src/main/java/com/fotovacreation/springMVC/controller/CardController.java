package com.fotovacreation.springMVC.controller;

import com.fotovacreation.springMVC.model.CardEntity;
import com.fotovacreation.springMVC.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CardController
{
    @Autowired
    private CardService cardService;

    @GetMapping("/card")
    public String getAllCard(Model model)
    {
        List<CardEntity> cardEntities = cardService.getAllCard();
        model.addAttribute("cards", cardEntities);
        return "card";
    }
}
