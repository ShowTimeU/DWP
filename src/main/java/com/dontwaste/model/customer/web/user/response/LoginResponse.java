package com.dontwaste.model.customer.web.user.response;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String area;
    private String token;
    private String role;

}
