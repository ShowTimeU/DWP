package com.dontwaste.service;

import com.dontwaste.model.web.productTemplate.ProductTemplateCreationRequest;
import com.dontwaste.model.web.productTemplate.ProductTemplateResponse;

import java.util.List;

public interface ProductTemplateService {
    void addProductTemplate(ProductTemplateCreationRequest productTemplateCreationRequest);
    void deleteProductTemplate(Long id);
    List<ProductTemplateResponse> getAllProductTemplatesByInstitution(Long institutionId);
    ProductTemplateResponse getProductTeplate(Long id);
}
