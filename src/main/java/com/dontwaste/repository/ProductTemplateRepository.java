package com.dontwaste.repository;

import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.entity.ProductTemplate;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ProductTemplateRepository extends JpaRepository<ProductTemplate, Long> {

    List<ProductTemplate> findAllByInstitution(Institution institution);
}
