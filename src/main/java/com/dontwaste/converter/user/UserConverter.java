package com.dontwaste.converter.user;

import com.dontwaste.model.customer.entity.Session;
import com.dontwaste.model.customer.entity.User;
import com.dontwaste.model.customer.entity.UserRole;
import com.dontwaste.model.customer.web.user.UserCreateRequest;
import com.dontwaste.model.customer.web.user.response.LoginResponse;
import com.dontwaste.model.customer.web.user.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

@Component
public class UserConverter {

    @Autowired
    PasswordConverter passwordConverter;

    public User convertToEntity(UserCreateRequest userCreateRequest) throws NoSuchAlgorithmException {
        return User.builder()
                .firstName(userCreateRequest.getFirstName())
                .lastName(userCreateRequest.getLastName())
                .email(userCreateRequest.getEmail())
                .password(passwordConverter.getHash(userCreateRequest.getPassword()))
                .phone(userCreateRequest.getPhone())
                .build();
    }

    public UserResponse convertUserToWeb(User user){
        return UserResponse.builder()
                .id(user.getId())
                .createdOn(user.getCreatedOn())
                .updatedOn(user.getUpdatedOn())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    public LoginResponse loginResponse(User user, Session session, UserRole userRole){
        return LoginResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .token(session.getToken())
                .role(userRole.getRole().getRoleName())
                .build();
    }

}
