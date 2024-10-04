package com.fotovacreation.springMVC.service;

import com.fotovacreation.springMVC.model.FurnitureEntity;
import com.fotovacreation.springMVC.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService
{
    @Autowired
    private FurnitureRepository furnitureRepository;

    public FurnitureEntity getById(int id)
    {
        return furnitureRepository.findById(id).orElseThrow();
    }

    public Page<FurnitureEntity> getAllWithPage(int page, int size)
    {
        Pageable pageable = PageRequest.of(page,size);
        return furnitureRepository.findAll(pageable);
    }
}