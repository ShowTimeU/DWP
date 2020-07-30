package com.dontwaste.repository;

import com.dontwaste.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByIsDefaultTrue();

}
