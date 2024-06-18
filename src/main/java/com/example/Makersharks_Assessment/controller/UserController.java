package com.example.Makersharks_Assessment.controller;

import com.example.Makersharks_Assessment.payload.UserDto;
import com.example.Makersharks_Assessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public  UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/fetch")
    public ResponseEntity<UserDto> getUserByUsername(@RequestParam(value = "username")String username){
        UserDto userByUsername = userService.getUserByUsername(username);
        return ResponseEntity.ok(userByUsername);
    }
}
