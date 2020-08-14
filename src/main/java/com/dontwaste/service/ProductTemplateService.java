package com.dontwaste.service;

import com.dontwaste.model.entity.ProductTemplate;
import com.dontwaste.model.web.productTemplate.ProductTemplateCreationRequest;
import com.dontwaste.model.web.productTemplate.ProductTemplateResponse;

import java.util.List;
import java.util.Set;

public interface ProductTemplateService {
    void addProductTemplate(ProductTemplateCreationRequest productTemplateCreationRequest);
    void deleteProductTemplate(Long id);
    List<ProductTemplateResponse> getAllProductTemplatesByInstitution(Long institutionId);
    ProductTemplateResponse getProductTemplate(Long id);
}
