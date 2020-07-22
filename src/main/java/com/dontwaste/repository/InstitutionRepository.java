package com.dontwaste.repository;

import com.dontwaste.model.customer.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    Institution getInstitutionByInstitutionEmail(String email);

}
