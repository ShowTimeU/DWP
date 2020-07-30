package com.dontwaste.converter;

import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.web.institution.CreateInstitutionRequest;
import com.dontwaste.model.web.institution.InstitutionResponse;
import org.springframework.stereotype.Component;

@Component
public class InstitutionConverter {

    public Institution convertToEntity(CreateInstitutionRequest createInstitutionRequest) {
        return Institution.builder()
                .institutionName(createInstitutionRequest.getInstitutionName())
                .institutionWebSite(createInstitutionRequest.getInstitutionWebSite())
                .institutionLogo(createInstitutionRequest.getInstitutionLogo())
                .institutionDescription(createInstitutionRequest.getInstitutionDescription())
                .build();
    }

    public InstitutionResponse convertToWeb(Institution institution){
        return InstitutionResponse.builder()
                .id(institution.getId())
                .institutionName(institution.getInstitutionName())
                .institutionLogo(institution.getInstitutionLogo())
                .institutionWebSite(institution.getInstitutionWebSite())
                .institutionDescription(institution.getInstitutionDescription())
                .build();
    }

}
