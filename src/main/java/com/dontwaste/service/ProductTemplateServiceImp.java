package com.dontwaste.service;

import com.dontwaste.converter.ProductTemplateConverter;
import com.dontwaste.exception.InstitutionNotFoundException;
import com.dontwaste.exception.KitchenDishTypeNotFoundException;
import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.entity.ProductTemplate;
import com.dontwaste.model.entity.product.productType.DishType;
import com.dontwaste.model.entity.product.productType.KitchenType;
import com.dontwaste.model.web.productTemplate.ProductTemplateCreationRequest;
import com.dontwaste.model.web.productTemplate.ProductTemplateResponse;
import com.dontwaste.repository.InstitutionRepository;
import com.dontwaste.repository.ProductTemplateRepository;
import com.dontwaste.repository.productTypes.DishTypeRepository;
import com.dontwaste.repository.productTypes.KitchenTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProductTemplateServiceImp implements ProductTemplateService {
    @Autowired
    ProductTemplateRepository productTemplateRepository;
    @Autowired
    InstitutionRepository institutionRepository;
    @Autowired
    ProductTemplateConverter productTemplateConverter;
    @Autowired
    KitchenTypeRepository kitchenTypeRepository;
    @Autowired
    DishTypeRepository dishTypeRepository;

    @Override
    public void addProductTemplate(ProductTemplateCreationRequest productTemplateCreationRequest) {
        Institution institution = institutionRepository.findById(
                productTemplateCreationRequest.getInstitutionId()).orElse(null);
        DishType dishType = dishTypeRepository.findById(
                productTemplateCreationRequest.getDishTypeId()).orElse(null);
        KitchenType kitchenType = kitchenTypeRepository.findById(
                productTemplateCreationRequest.getDishTypeId()).orElse(null);
        if(institution == null){
            throw new InstitutionNotFoundException("institution is not exist");
        }
        if(dishType == null){
            throw new KitchenDishTypeNotFoundException("dishType is not exist");
        }
        if(kitchenType == null){
            throw new KitchenDishTypeNotFoundException("kitchenType is not exist");
        }

        ProductTemplate productTemplate = productTemplateConverter.convertToEntity(
                                                            productTemplateCreationRequest,
                                                            institution, dishType, kitchenType);

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
            throw new InstitutionNotFoundException("Wrong institution");
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
