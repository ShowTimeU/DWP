package com.dontwaste.service;

import com.dontwaste.model.customer.entity.Role;
import com.dontwaste.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void addRole(String roleName) {
        Role role = Role.builder()
                .roleName(roleName)
                .build();
        roleRepository.save(role);
    }


}
