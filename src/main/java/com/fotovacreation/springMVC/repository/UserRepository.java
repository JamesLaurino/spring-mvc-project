package com.fotovacreation.springMVC.repository;

import com.fotovacreation.springMVC.model.UserDto;
import com.fotovacreation.springMVC.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Integer>
{
    UserEntity findByUsername(final String username);
}
