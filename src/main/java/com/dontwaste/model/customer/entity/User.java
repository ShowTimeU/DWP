package com.dontwaste.model.customer.entity;

import com.dontwaste.model.customer.base.BaseDate;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "USER")
public class User extends BaseDate {
    @Column(name = "FIRSTNAME", length = 80, nullable = false)
    private String firstName;
    @Column(name = "LASTNAME", length = 80, nullable = false)
    private String lastName;
    @Column(name = "EMAIL", length = 50, nullable = false, unique = true)
    private String email;
    @Column(name = "PASSWORD", length = 64, nullable = false)
    private String password;
//    @Column(name = "USERSALT", length = 64, nullable = false)
//    private String userSalt;

    @Column(name = "PHONE", length = 20, nullable = false)
    private String phone;
    @Column(name = "AREA", length = 100)
    private String area;
}
