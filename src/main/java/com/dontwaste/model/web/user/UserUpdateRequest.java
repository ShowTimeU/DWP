package com.dontwaste.model.web.user;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserUpdateRequest {
    @NotBlank
    private Long id;
    @NotBlank
    @Length(min = 2, max = 20)
    private String firstName;
    @NotBlank
    @Length(min = 2, max = 20)
    private String lastName;
    @NotBlank
    @Length(max = 20)
    private String phone;
    @NotBlank
    @Length(max = 100)
    private String area;

}
