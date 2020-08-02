package com.dontwaste.service;

import com.dontwaste.converter.ProductTemplateConverter;
import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.entity.ProductTemplate;
import com.dontwaste.model.web.productTemplate.ProductTemplateCreationRequest;
import com.dontwaste.model.web.productTemplate.ProductTemplateResponse;
import com.dontwaste.repository.InstitutionRepository;
import com.dontwaste.repository.ProductTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductTemplateServiceImp implements ProductTemplateService {
    @Autowired
    ProductTemplateRepository productTemplateRepository;
    @Autowired
    InstitutionRepository institutionRepository;
    @Autowired
    ProductTemplateConverter productTemplateConverter;

    @Override
    public void addProductTemplate(ProductTemplateCreationRequest productTemplateCreationRequest) {
        Institution institution = institutionRepository.findById(productTemplateCreationRequest.getInstitutionId()).get();
        if(institution == null){
            throw new RuntimeException("institution is not exist");
        }
        ProductTemplate productTemplate = productTemplateConverter.convertToEntity(
                                                            productTemplateCreationRequest,
                                                            institution);
        productTemplateRepository.save(productTemplate);
    }

    @Override
    public void deleteProductTemplate(Long id) {
                productTemplateRepository.deleteById(id);
    }

    @Override
    public List<ProductTemplateResponse> getAllProductTemplatesByInstitution(Long institutionId) {
        List<ProductTemplateResponse> templates = new ArrayList<>();
        Institution institution = institutionRepository.findById(institutionId).orElse(null);
        if(institution == null){
            throw new RuntimeException("Wrong institution");
        }
        List<ProductTemplate> lt = productTemplateRepository.findAllByInstitution(institution);
        for(ProductTemplate productTemplate : lt){
            templates.add(productTemplateConverter.convertToWeb(productTemplate));
        }
//        productTemplateRepository.findAllByInstitution_Id(institutionId).stream()
//                .map(productTemplate -> templates.add(productTemplateConverter.convertToWeb(productTemplate)));
         return templates;
    }

    @Override
    public ProductTemplateResponse getProductTemplate(Long id) {
        return productTemplateConverter.convertToWeb(productTemplateRepository.findById(id).get());
    }
}
