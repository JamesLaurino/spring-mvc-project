package com.fotovacreation.springMVC.controller;

import com.fotovacreation.springMVC.model.CardEntity;
import com.fotovacreation.springMVC.repository.CardRepository;
import com.fotovacreation.springMVC.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class CardController
{
    @Autowired
    private CardService cardService;

    @Autowired
    private CardRepository cardRepository;

    @Value("${file.upload.path}")
    private String pathFile;

    @GetMapping("/card/form")
    public String postPhoto(Model model)
    {
        CardEntity cardEntity = new CardEntity();
        model.addAttribute("cardEntity", cardEntity);
        return "card-add";
    }

    @PostMapping("/card/add")
    public String addProduct(@RequestParam("file") MultipartFile file,
                             @ModelAttribute("cardEntity") CardEntity cardEntity,
                             RedirectAttributes redirectAttributes)
    {
        if(file.isEmpty())
        {
            redirectAttributes.addFlashAttribute("message", "please select a file");
            return "redirect:/product/error";
        }

        try
        {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(pathFile + file.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message",
            "You successfully uploaded : " + file.getOriginalFilename());

            cardEntity.setPhotoUrl(file.getOriginalFilename());
            cardRepository.save(cardEntity);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "redirect:/product/error";
        }

        return "redirect:/card";
    }


    @GetMapping("/card")
    public String getAllCard(Model model)
    {
        List<CardEntity> cardEntities = cardService.getAllCard();
        model.addAttribute("cards", cardEntities);
        return "card";
    }
}
