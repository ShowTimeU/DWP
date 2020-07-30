package com.dontwaste.model.web.institution;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class InstitutionResponse {


    private Long id;
    private String institutionName;
    private String institutionWebSite;
    private String institutionLogo;
    private String institutionDescription;

}
