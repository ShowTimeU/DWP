package com.dontwaste.controller;

import com.dontwaste.model.web.institution.CreateInstitutionRequest;
import com.dontwaste.model.web.institution.InstitutionResponse;
import com.dontwaste.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/institution")
public class InstitutionController {

    @Autowired
    InstitutionService institutionService;

    @PostMapping(value = "/addInstitution")
    public void addInstitution(@RequestBody CreateInstitutionRequest createInstitutionRequest) throws NoSuchAlgorithmException {
        institutionService.addInstitution(createInstitutionRequest);
    }

    @GetMapping(value = "/getAllInstitutions")
    public List<InstitutionResponse> getAllInstitutions(){
        return institutionService.getAllInstitutions();
    }

    @DeleteMapping("/deleteInstitution")
    public void deleteInstitution(@RequestParam Long id){
        institutionService.deleteInstitution(id);
    }

}
