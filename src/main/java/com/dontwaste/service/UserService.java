package com.dontwaste.service;

import com.dontwaste.model.customer.entity.User;
import com.dontwaste.model.customer.web.user.UserCreateRequest;
import com.dontwaste.model.customer.web.user.UserLoginRequest;
import com.dontwaste.model.customer.web.user.UserUpdateRequest;
import com.dontwaste.model.customer.web.user.response.LoginResponse;
import com.dontwaste.model.customer.web.user.response.UserResponse;

import java.security.NoSuchAlgorithmException;
import java.util.List;


public interface UserService {
    UserResponse createUser(UserCreateRequest userCreateRequest) throws NoSuchAlgorithmException;
    void deleteUser(Long id);
    LoginResponse login(UserLoginRequest userLoginRequest) throws NoSuchAlgorithmException;
    Boolean updateUser(UserUpdateRequest userUpdateRequest);
    UserResponse getUserById(Long id);
    void logout(String token);
    List<User> getAllUsers();





}
