package com.dontwaste.controller;

import com.dontwaste.model.web.user.UserCreateRequest;
import com.dontwaste.model.web.user.UserLoginRequest;
import com.dontwaste.model.web.user.response.LoginResponse;
import com.dontwaste.model.web.user.response.UserResponse;
import com.dontwaste.service.PasswordResetService;
import com.dontwaste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    PasswordResetService passwordResetService;

    @PostMapping(value = "/registration")
    public UserResponse createUser(@RequestBody UserCreateRequest userCreateRequest) throws NoSuchAlgorithmException {
        return userService.createUser(userCreateRequest);
    }

    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody UserLoginRequest userLoginRequest) throws NoSuchAlgorithmException {
        return userService.login(userLoginRequest);
    }

    @GetMapping(value = "/resetPassword")
    public void resetPassword(@RequestParam(name = "email") String email){
        passwordResetService.createRequestToPasswordReset(email);
    }

    @GetMapping("/checkChangePasswordRequest")
    public boolean checkChangePasswordRequest(@RequestParam(name = "id") Long id,
                                              @RequestParam(name = "token") String token){
        return passwordResetService.checkChangePasswordRequest(id, token);
    }

    @PostMapping(value = "/changeUserPassword")
    public void changeUserPassword(@RequestParam(name = "id") Long id,
                                   @RequestParam(name = "newPassword") String newPassword){
        passwordResetService.changeUserPassword(id, newPassword);
    }


}
