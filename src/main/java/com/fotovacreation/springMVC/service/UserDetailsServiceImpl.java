package com.fotovacreation.springMVC.service;

import com.fotovacreation.springMVC.model.UserDto;
import com.fotovacreation.springMVC.model.UserEntity;
import com.fotovacreation.springMVC.repository.UserRepository;
import com.fotovacreation.springMVC.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        final UserEntity userEntity = repository.findByUsername(username);

        if(userEntity == null) {
            throw new UsernameNotFoundException("Unknown user "+ username);
        }

        return userMapper.entityToDto(userEntity);
    }
}
