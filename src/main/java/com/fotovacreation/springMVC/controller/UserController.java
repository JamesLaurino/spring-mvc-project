package com.fotovacreation.springMVC.controller;

import com.fotovacreation.springMVC.model.UserDto;
import com.fotovacreation.springMVC.model.UserEntity;
import com.fotovacreation.springMVC.repository.UserRepository;
import com.fotovacreation.springMVC.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public String getUser(Model model)
    {
        List<UserEntity> userEntity = userRepository.findAll();
        List<UserDto> userDtos = userMapper.entitiesToDtos(userEntity);
        model.addAttribute("users", userDtos);

        return "users-administration";
    }
}