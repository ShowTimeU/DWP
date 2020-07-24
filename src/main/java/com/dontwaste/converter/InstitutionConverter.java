package com.dontwaste.converter;

import com.dontwaste.model.customer.entity.Institution;
import com.dontwaste.model.customer.entity.User;
import com.dontwaste.model.customer.web.institution.CreateInstitutionRequest;
import com.dontwaste.model.customer.web.institution.InstitutionResponse;
import org.springframework.stereotype.Component;

@Component
public class InstitutionConverter {


    public Institution convertToEntity(CreateInstitutionRequest createInstitutionRequest, User user) {
        return Institution.builder()
                .institutionName(createInstitutionRequest.getInstitutionName())
                .institutionAddress(createInstitutionRequest.getInstitutionAddress())
                .institutionCity(createInstitutionRequest.getInstitutionCity())
                .institutionPhone(createInstitutionRequest.getInstitutionPhone())
                .institutionWebSite(createInstitutionRequest.getInstitutionWebSite())
                .institutionLogo(createInstitutionRequest.getInstitutionLogo())
                .user(user)
                .build();
    }

    public InstitutionResponse convertToWeb(Institution institution){
        return InstitutionResponse.builder()
                .id(institution.getId())
                .institutionName(institution.getInstitutionName())
                .institutionCity(institution.getInstitutionCity())
                .institutionAddress(institution.getInstitutionAddress())
                .institutionLogo(institution.getInstitutionLogo())
                .institutionPhone(institution.getInstitutionPhone())
                .institutionWebSite(institution.getInstitutionWebSite())
                .build();
    }

}
