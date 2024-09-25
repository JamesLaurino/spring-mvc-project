package com.fotovacreation.springMVC.repository;

import com.fotovacreation.springMVC.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserDto, Integer>
{
    UserDto findByUsername(final String username);
}
