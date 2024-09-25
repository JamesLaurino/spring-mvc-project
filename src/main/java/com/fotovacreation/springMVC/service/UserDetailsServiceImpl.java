package com.fotovacreation.springMVC.service;

import com.fotovacreation.springMVC.model.ProductDto;
import com.fotovacreation.springMVC.model.UserDto;
import com.fotovacreation.springMVC.repository.UserRepository;
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

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        final UserDto userDto = repository.findByUsername(username);

        if(userDto == null) {
            throw new UsernameNotFoundException("Unknown user "+ username);
        }
        return User.withUsername(userDto.getUsername())
                .password(userDto.getPassword())
                .roles(userDto.getRole())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
