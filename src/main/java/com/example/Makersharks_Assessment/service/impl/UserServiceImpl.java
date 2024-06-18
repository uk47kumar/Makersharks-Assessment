package com.example.Makersharks_Assessment.service.impl;

import com.example.Makersharks_Assessment.entity.User;
import com.example.Makersharks_Assessment.exception.ResourceNotFoundException;
import com.example.Makersharks_Assessment.payload.UserDto;
import com.example.Makersharks_Assessment.repository.UserRepository;
import com.example.Makersharks_Assessment.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepository.findByUsername(username).
                orElseThrow(() -> new ResourceNotFoundException("Username not found"));
        return mapToDTO(user);
    }

    private UserDto mapToDTO(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
