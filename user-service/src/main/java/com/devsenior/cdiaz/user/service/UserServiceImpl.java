package com.devsenior.cdiaz.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.cdiaz.user.model.dto.UserResponse;
import com.devsenior.cdiaz.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userEntity -> new UserResponse(
                        userEntity.getId(),
                        userEntity.getName(),
                        userEntity.getEmail()))
                .toList();
    }

    @Override
    public UserResponse getUserById(Long id) {
        return userRepository.findById(id)
                .map(userEntity -> new UserResponse(
                        userEntity.getId(),
                        userEntity.getName(),
                        userEntity.getEmail()))
                .orElse(null);
    }
}
