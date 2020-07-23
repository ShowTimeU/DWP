package com.dontwaste.service;

import com.dontwaste.converter.user.PasswordConverter;
import com.dontwaste.converter.user.UserConverter;
import com.dontwaste.model.customer.entity.Role;
import com.dontwaste.model.customer.entity.Session;
import com.dontwaste.model.customer.entity.User;
import com.dontwaste.model.customer.entity.UserRole;
import com.dontwaste.model.customer.web.user.UserCreateRequest;
import com.dontwaste.model.customer.web.user.UserLoginRequest;
import com.dontwaste.model.customer.web.user.UserUpdateRequest;
import com.dontwaste.model.customer.web.user.response.LoginResponse;
import com.dontwaste.model.customer.web.user.response.UserResponse;
import com.dontwaste.repository.RoleRepository;
import com.dontwaste.repository.UserRepository;
import com.dontwaste.repository.UserRoleRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserConverter userConverter;

    @Autowired
    SessionService sessionService;

    @Autowired
    PasswordConverter passwordConverter;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepositoty userRoleRepositoty;

    @Override
    public UserResponse createUser(UserCreateRequest userCreateRequest) throws NoSuchAlgorithmException {
        User user = userConverter.convertToEntity(userCreateRequest);
        userRepository.save(user);
        Role defaultRole = roleRepository.findByIsDefaultTrue();
        UserRole userRole = UserRole.builder()
                .user(user)
                .role(defaultRole)
                .build();
        userRoleRepositoty.save(userRole);
        return userConverter.convertUserToWeb(user);
    }


    @Override
    public Boolean updateUser(UserUpdateRequest userUpdateRequest) {
        User userToUpdate = userRepository.findById(userUpdateRequest.getId()).get();
        if(userToUpdate == null){
            throw new RuntimeException("This user is not exist in database");
        }
        userToUpdate.setArea(userUpdateRequest.getArea());
        userToUpdate.setFirstName(userUpdateRequest.getFirstName());
        userToUpdate.setLastName(userUpdateRequest.getLastName());
        userToUpdate.setPhone(userUpdateRequest.getPhone());
        User trueSave = userRepository.save(userToUpdate);
        if(trueSave != null){
            return true;
        }
        return false;
    }

    @Override
    public UserResponse getUserById(Long id){
        User user = userRepository.findById(id).get();
        return userConverter.convertUserToWeb(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public LoginResponse login(UserLoginRequest userLoginRequest) throws NoSuchAlgorithmException {
        User user = userRepository.findByEmailAndPassword(
                userLoginRequest.getEmail(),
                passwordConverter.getHash(userLoginRequest.getPassword())
        );
        if(user==null){
            //return new UserResponse();
            throw new RuntimeException("Incorrect user or password");
        }

        Session userSession = Session.builder()
                .user(user)
                .token(UUID.randomUUID().toString())
                .build();
        sessionService.addSession(userSession);
        UserRole userRole = userRoleRepositoty.getByUser(user);
        return userConverter.loginResponse(user, userSession, userRole);
    }

}
