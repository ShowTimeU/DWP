package com.dontwaste.model.customer.web.user;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class UserLoginRequest {
    @NotBlank
    @Length(min = 6, max = 40)
    private String email;
    @NotBlank
    @Length(min = 8, max = 20)
    private String password;


}
