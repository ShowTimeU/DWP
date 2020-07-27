package com.dontwaste.service;

import com.dontwaste.converter.InstitutionConverter;
import com.dontwaste.model.customer.entity.Institution;
import com.dontwaste.model.customer.entity.User;
import com.dontwaste.model.customer.web.institution.CreateInstitutionRequest;
import com.dontwaste.model.customer.web.institution.InstitutionResponse;
import com.dontwaste.repository.InstitutionRepository;
import com.dontwaste.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstitutionServiceImp implements InstitutionService{

    @Autowired
    InstitutionRepository institutionRepository;

    @Autowired
    InstitutionConverter institutionConverter;

    @Autowired
    UserRepository userRepository;

//    @Override
//    public void createInstitution(CreateInstitutionRequest createInstitutionRequest) throws NoSuchAlgorithmException {
//        Institution institution = institutionConverter.convertToEntity(createInstitutionRequest);
//        institutionRepository.save(institution);
//    }
//
//    @Override
//    public Institution getInstitutionByEmail(String email) {
//        return institutionRepository.getInstitutionByInstitutionEmail(email);
//    }
//
//    @Override
//    public List<InstitutionResponse> getAllInstitutions() {
//        return institutionRepository.findAll().stream()
//                .map(institution -> institutionConverter.convertToWeb(institution))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteInstitution(Long id) {
//        institutionRepository.deleteById(id);
//    }
}
