package com.dontwaste.model.web.institution;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateInstitutionRequest {
    @NotBlank
    @Length(max = 20)
    private String institutionName;
    @Length(max = 30)
    private String institutionWebSite;
    @Length(max = 2600)
    private String institutionLogo;
    @NotBlank
    @Length(max = 500)
    private String institutionDescription;

}
