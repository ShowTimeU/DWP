package com.dontwaste.model.customer.web.institution;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateInstitutionRequest {

    private String institutionName;

    private String institutionCity;

    private String institutionAddress;

    private String institutionPhone;

    private String institutionWebSite;

    private String institutionLogo;

}
