package com.dontwaste.controller;

import com.dontwaste.model.customer.web.user.UserCreateRequest;
import com.dontwaste.model.customer.web.user.UserLoginRequest;
import com.dontwaste.model.customer.web.user.response.LoginResponse;
import com.dontwaste.model.customer.web.user.response.UserResponse;
import com.dontwaste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/registration")
    public UserResponse createUser(@RequestBody UserCreateRequest userCreateRequest) throws NoSuchAlgorithmException {
        return userService.createUser(userCreateRequest);
    }

    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody UserLoginRequest userLoginRequest) throws NoSuchAlgorithmException {
        return userService.login(userLoginRequest);
    }
}
