package com.devsenior.cdiaz.user.service;

import java.util.List;

import com.devsenior.cdiaz.user.model.dto.UserResponse;

public interface UserService {
    
    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);
}
