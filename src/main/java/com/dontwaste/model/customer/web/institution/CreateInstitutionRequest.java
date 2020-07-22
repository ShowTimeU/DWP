package com.dontwaste.model.customer.web.institution;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateInstitutionRequest {

    private String institutionName;

    private String institutionPassword;

    private String institutionCity;

    private String institutionAddress;

    private String institutionPhone;

    private String institutionEmail;

    private String institutionWebSite;

    private String institutionComment;

    private String institutionLogo;

}
