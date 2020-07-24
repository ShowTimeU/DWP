package com.dontwaste;

import com.dontwaste.model.customer.entity.Institution;
import com.dontwaste.model.customer.entity.Role;
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
                .institutionCity("Haifa")
                .institutionAddress("Mashava HaGermanit 5")
                .institutionPhone("12345678")
                .institutionLogo("JapanicaLogo")
                .institutionWebSite("japanica.com")
                .build();

        Institution institution2 = Institution.builder()
                .institutionName("Burger Salun")
                .institutionCity("Tel-Aviv")
                .institutionAddress("Rotchild 53")
                .institutionPhone("87654321")
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
                .isDefault(false)
                .build();
        Role admin = Role.builder()
                .roleName("ADMIN")
                .isDefault(false)
                .build();

        roleRepository.saveAll(Arrays.asList(user,manager,admin));
    }
}
