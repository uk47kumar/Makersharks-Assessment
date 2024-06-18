package com.example.Makersharks_Assessment.service.impl;

import com.example.Makersharks_Assessment.entity.User;
import com.example.Makersharks_Assessment.exception.ApiException;
import com.example.Makersharks_Assessment.payload.RegisterDto;
import com.example.Makersharks_Assessment.repository.UserRepository;
import com.example.Makersharks_Assessment.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public String register(RegisterDto registerDto) {

        // add check for username exists in database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new ApiException(BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new ApiException(BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());

        userRepository.save(user);

        return "User registered successfully!.";
    }

}
