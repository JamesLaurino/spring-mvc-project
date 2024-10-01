package com.fotovacreation.springMVC.service;

import com.fotovacreation.springMVC.model.CardEntity;
import com.fotovacreation.springMVC.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService
{
    @Autowired
    private CardRepository cardRepository;

    public List<CardEntity> getAllCard()
    {
        return cardRepository.findAll();
    }

}
