package com.dontwaste;

import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.entity.Role;
import com.dontwaste.repository.InstitutionRepository;
import com.dontwaste.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    InstitutionRepository institutionRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        addInstitutions();
//        addRoles();
    }

    private void addInstitutions(){
        Institution institution1 = Institution.builder()
                .institutionName("Japanica")
                .institutionLogo("JapanicaLogo")
                .institutionWebSite("japanica.com")
                .build();

        Institution institution2 = Institution.builder()
                .institutionName("Burger Salun")
                .institutionLogo("BurgerSalunLogo")
                .institutionWebSite("BurgerSalun.net")
                .build();

        institutionRepository.saveAll(Arrays.asList(institution1, institution2));
    }
    private void addRoles(){
        Role user = Role.builder()
                .roleName("USER")
                .isDefault(true)
                .build();
        Role manager = Role.builder()
                .roleName("MANAGER")
                .build();
        Role admin = Role.builder()
                .roleName("ADMIN")
                .build();

        roleRepository.saveAll(Arrays.asList(user,manager,admin));
    }
}
