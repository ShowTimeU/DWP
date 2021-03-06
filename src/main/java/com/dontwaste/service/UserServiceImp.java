package com.dontwaste.service;

import com.dontwaste.converter.user.PasswordConverter;
import com.dontwaste.converter.user.UserConverter;
import com.dontwaste.exception.UserLoginException;
import com.dontwaste.exception.UserNotFoundException;
import com.dontwaste.model.entity.*;
import com.dontwaste.model.web.user.UserCreateRequest;
import com.dontwaste.model.web.user.UserLoginRequest;
import com.dontwaste.model.web.user.UserUpdateRequest;
import com.dontwaste.model.web.user.response.LoginResponse;
import com.dontwaste.model.web.user.response.LoginResponseForManager;
import com.dontwaste.model.web.user.response.UserResponse;
import com.dontwaste.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
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

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    ProductTemplateRepository productTemplateRepository;

    @Override
    public UserResponse createUser(UserCreateRequest userCreateRequest) {
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
            throw new UserNotFoundException("This user is not exist in database");
        }
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
    public List<User> getAllUsers() {
        return userRepository.findAll();
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
    public LoginResponse login(UserLoginRequest userLoginRequest) {
        User user = userRepository.findByEmail(
                userLoginRequest.getEmail()
        );
        if(user==null || !passwordConverter.comparePasswords(user.getPassword(), userLoginRequest.getPassword())){
            throw new UserLoginException("Incorrect user or password");
        }

        Session userSession = Session.builder()
                .user(user)
                .token(UUID.randomUUID().toString())
                .build();
        sessionService.addSession(userSession);
        UserRole userRole = userRoleRepositoty.getByUser(user);

        if(userRole.getRole().getRoleName().equals("MANAGER")){
            Branch branch = branchRepository.findByUser(user);
            Institution institution = branch.getInstitution();
            List<ProductTemplate> templates = productTemplateRepository.findAllByInstitution(institution);
            return  LoginResponseForManager.childBuilder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .phone(user.getPhone())
                    .token(userSession.getToken())
                    .role(userRole.getRole().getRoleName())
                    .institution(institution)
                    .branch(branch)
                    .templates(templates)
                    .build();
        }
        return userConverter.loginResponse(user, userSession, userRole);
    }

    @Override
    public void logout(String token) {
        sessionService.deleteSessionByToken(token);
    }
}
