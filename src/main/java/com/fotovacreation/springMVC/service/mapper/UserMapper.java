package com.fotovacreation.springMVC.service.mapper;

import com.fotovacreation.springMVC.model.UserDto;
import com.fotovacreation.springMVC.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapper
{
    public UserDto entityToDto(UserEntity userEntity)
    {
        UserDto userDto = new UserDto();
        userDto.setPassword(userEntity.getPassword());
        userDto.setUsername(userEntity.getUsername());
        userDto.setAuthorities(userEntity.getRole());
        userDto.setId(userEntity.getId());

        return userDto;
    }

    public List<UserDto> entitiesToDtos(List<UserEntity> userEntities)
    {
        List<UserDto> userDtos = new ArrayList<>();

        for(UserEntity userEntity : userEntities)
        {
            UserDto userDto = new UserDto();
            userDto.setPassword(userEntity.getPassword());
            userDto.setUsername(userEntity.getUsername());
            userDto.setAuthorities(userEntity.getRole());
            userDto.setId(userEntity.getId());
            userDtos.add(userDto);
        }

        return userDtos;
    }
}
