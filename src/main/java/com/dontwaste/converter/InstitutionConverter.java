package com.dontwaste.converter;

import com.dontwaste.converter.user.PasswordConverter;
import com.dontwaste.model.customer.entity.Institution;
import com.dontwaste.model.customer.web.institution.CreateInstitutionRequest;
import com.dontwaste.model.customer.web.institution.InstitutionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

@Component
public class InstitutionConverter {

    @Autowired
    PasswordConverter passwordConverter;

    public Institution convertToEntity(CreateInstitutionRequest createInstitutionRequest) throws NoSuchAlgorithmException {
        return Institution.builder()
                .institutionName(createInstitutionRequest.getInstitutionName())
                .institutionPassword(passwordConverter.getHash(createInstitutionRequest.getInstitutionPassword()))
                .institutionEmail(createInstitutionRequest.getInstitutionEmail())
                .institutionAddress(createInstitutionRequest.getInstitutionAddress())
                .institutionCity(createInstitutionRequest.getInstitutionCity())
                .institutionPhone(createInstitutionRequest.getInstitutionPhone())
                .institutionWebSite(createInstitutionRequest.getInstitutionWebSite())
                .institutionComment(createInstitutionRequest.getInstitutionComment())
                .institutionLogo(createInstitutionRequest.getInstitutionLogo())
                .build();
    }

    public InstitutionResponse convertToWeb(Institution institution){
        return InstitutionResponse.builder()
                .id(institution.getId())
                .institutionName(institution.getInstitutionName())
                .institutionCity(institution.getInstitutionCity())
                .institutionAddress(institution.getInstitutionAddress())
                .institutionEmail(institution.getInstitutionEmail())
                .institutionLogo(institution.getInstitutionLogo())
                .institutionPhone(institution.getInstitutionPhone())
                .institutionWebSite(institution.getInstitutionWebSite())
                .institutionComment(institution.getInstitutionComment())
                .build();
    }

}
