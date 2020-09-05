package com.dontwaste.model.entity;

import com.dontwaste.model.base.BaseDate;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
    @Column(name = "PHONE", length = 20, nullable = false)
    private String phone;
}
