package com.dontwaste.controller;

import com.dontwaste.model.customer.entity.Institution;
import com.dontwaste.model.customer.web.institution.CreateInstitutionRequest;
import com.dontwaste.model.customer.web.institution.InstitutionResponse;
import com.dontwaste.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/institution")
public class InstitutionController {

    @Autowired
    InstitutionService institutionService;

//    @PostMapping(value = "/createInstitution")
//    public void createInstitution(@RequestBody CreateInstitutionRequest createInstitutionRequest) throws NoSuchAlgorithmException {
//        institutionService.createInstitution(createInstitutionRequest);
//    }
//
//    @GetMapping(value = "/getInstitution")
//    public Institution getInstitutionByEmail(@RequestParam String email){
//        return institutionService.getInstitutionByEmail(email);
//    }
//
//    @GetMapping(value = "/getAllInstitutions")
//    public List<InstitutionResponse> getAllInstitutions(){
//        return institutionService.getAllInstitutions();
//    }
//
//    @DeleteMapping("/deleteInstitution")
//    public void deleteInstitution(@RequestParam Long id){
//        institutionService.deleteInstitution(id);
//    }

}
