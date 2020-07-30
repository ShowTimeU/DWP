package com.dontwaste.service;

import com.dontwaste.model.web.institution.CreateInstitutionRequest;
import com.dontwaste.model.web.institution.InstitutionResponse;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface InstitutionService {

    void addInstitution(CreateInstitutionRequest createInstitutionRequest) throws NoSuchAlgorithmException;
    List<InstitutionResponse> getAllInstitutions();
    void deleteInstitution(Long id);

}
