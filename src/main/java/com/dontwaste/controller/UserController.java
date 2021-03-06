package com.dontwaste.controller;


import com.dontwaste.model.entity.User;
import com.dontwaste.model.web.user.UserUpdateRequest;
import com.dontwaste.model.web.user.response.UserResponse;
import com.dontwaste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @DeleteMapping(value = "/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PostMapping(value = "/updateUser")
    public Boolean updateUser(@RequestBody UserUpdateRequest userUpdateRequest){
        return userService.updateUser(userUpdateRequest);
    }

    @GetMapping(value = "/getUser/{id}")
    public UserResponse getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping(value = "/allUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping(value = "/logout")
    public void logout(@RequestParam String token){
        userService.logout(token);
    }

}
