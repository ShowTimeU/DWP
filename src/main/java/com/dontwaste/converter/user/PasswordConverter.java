package com.dontwaste.converter.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordConverter {
    public final String SALT = "miktor";
    public final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public String getHashedPassword(String password) {
        password = password + SALT;
        return passwordEncoder.encode(password);
    }

    public boolean comparePasswords(String passFromBd, String rawPass){
        rawPass = rawPass + SALT;
        return passwordEncoder.matches(rawPass, passFromBd);

    }
}
