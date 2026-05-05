package com.devsenior.cdiaz.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.cdiaz.user.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
}
