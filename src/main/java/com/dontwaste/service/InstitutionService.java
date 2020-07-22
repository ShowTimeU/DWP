package com.dontwaste.service;

import com.dontwaste.model.customer.entity.Institution;
import com.dontwaste.model.customer.web.institution.CreateInstitutionRequest;
import com.dontwaste.model.customer.web.institution.InstitutionResponse;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface InstitutionService {

    void createInstitution(CreateInstitutionRequest createInstitutionRequest) throws NoSuchAlgorithmException;
    Institution getInstitutionByEmail(String email);
    List<InstitutionResponse> getAllInstitutions();
    void deleteInstitution(Long id);

}
