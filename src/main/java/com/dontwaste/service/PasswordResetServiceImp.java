package com.dontwaste.service;

import com.dontwaste.converter.user.PasswordConverter;
import com.dontwaste.exception.LinkIsNotValidException;
import com.dontwaste.exception.UserNotFoundException;
import com.dontwaste.model.entity.PasswordReset;
import com.dontwaste.model.entity.User;
import com.dontwaste.repository.PasswordResetRepository;
import com.dontwaste.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PasswordResetServiceImp implements PasswordResetService {
    @Autowired
    MailSender mailSender;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordResetRepository passwordResetRepository;

    @Autowired
    PasswordConverter passwordConverter;

    @Override
    public void createRequestToPasswordReset(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UserNotFoundException("User whis this Email not exists in DB");
        }
        PasswordReset passwordReset = passwordResetRepository.findByUser(user);
        if(passwordReset != null){
            passwordReset.setToken(UUID.randomUUID().toString());
            passwordReset.setExpiryDate(LocalDateTime.now().plusHours(1));
            passwordResetRepository.save(passwordReset);
        }
        else{
            passwordReset = PasswordReset.builder()
                    .user(user)
                    .token(UUID.randomUUID().toString())
                    .expiryDate(LocalDateTime.now().plusHours(1))
                    .build();
            passwordResetRepository.save(passwordReset);
        }

        String messageToUser = "<h3>Hello " +user.getEmail()+"</h3><br />"+
                "<a href =\"http://localhost:8080/recoveryPassword?id="
                +passwordReset.getId()+"&token="+passwordReset.getToken()+"\">" +
                "Link to recovery</a>";

//        mailSender.sendMail(user.getEmail(), "Recovery pass", messageToUser);
        mailSender.sendMail("pioner.pro13@gmail.com", "DontWaste - Recovery password", messageToUser);
    }

    @Override
    public boolean checkChangePasswordRequest(Long id, String token) {
        PasswordReset passwordReset = passwordResetRepository.findByIdAndToken(id,token);
        if(passwordReset == null){
            throw new LinkIsNotValidException("Link to change password not valid, order one more time");
        }
        if(LocalDateTime.now().isAfter(passwordReset.getExpiryDate())){
            passwordResetRepository.delete(passwordReset);
            throw new LinkIsNotValidException("Link expired, order one more time");
        }
        return true;
    }

    @Override
    public void changeUserPassword(Long id, String newPassword) {
        PasswordReset passwordReset = passwordResetRepository.findById(id).orElse(null);
        User userToUpdate = passwordReset.getUser();
        userToUpdate.setPassword(passwordConverter.getHashedPassword(newPassword));
        userRepository.save(userToUpdate);
        passwordResetRepository.delete(passwordReset);
    }

    @Override
    public void deleteRequestToPasswordReset(Long id) {

    }
}
