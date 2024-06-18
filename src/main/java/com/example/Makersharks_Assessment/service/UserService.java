package com.example.Makersharks_Assessment.service;

import com.example.Makersharks_Assessment.payload.UserDto;

public interface UserService {
    UserDto getUserByUsername(String username);
}
