package com.dontwaste.service;

import com.dontwaste.converter.InstitutionConverter;
import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.web.institution.CreateInstitutionRequest;
import com.dontwaste.model.web.institution.InstitutionResponse;
import com.dontwaste.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstitutionServiceImp implements InstitutionService{

    @Autowired
    InstitutionRepository institutionRepository;

    @Autowired
    InstitutionConverter institutionConverter;

    @Override
    public void addInstitution(CreateInstitutionRequest createInstitutionRequest) {
        Institution institution = institutionConverter.convertToEntity(createInstitutionRequest);
        institutionRepository.save(institution);
    }

    @Override
    public List<InstitutionResponse> getAllInstitutions() {
        return institutionRepository.findAll().stream()
                .map(institution -> institutionConverter.convertToWeb(institution))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteInstitution(Long id) {
        institutionRepository.deleteById(id);
    }
}
