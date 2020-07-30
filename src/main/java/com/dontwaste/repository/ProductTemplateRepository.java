package com.dontwaste.repository;

import com.dontwaste.model.entity.ProductTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTemplateRepository extends JpaRepository<ProductTemplate, Long> {

    List<ProductTemplate> findAllByInstitution_Id(Long institutionId);
}
