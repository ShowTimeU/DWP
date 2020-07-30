package com.dontwaste.converter;

import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.entity.ProductTemplate;
import com.dontwaste.model.web.productTemplate.ProductTemplateCreationRequest;
import com.dontwaste.model.web.productTemplate.ProductTemplateResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductTemplateConverter {

    public ProductTemplate convertToEntity(ProductTemplateCreationRequest productTemplateCreationRequest,
                                            Institution institution){
        return ProductTemplate.builder()
                .productName(productTemplateCreationRequest.getProductName())
                .productImage(productTemplateCreationRequest.getProductImage())
                .productDescription(productTemplateCreationRequest.getProductDescription())
                .institution(institution)
                .build();
    }

    public ProductTemplateResponse convertToWeb(ProductTemplate productTemplate){
        return ProductTemplateResponse.builder()
                .id(productTemplate.getId())
                .productName(productTemplate.getProductName())
                .productImage(productTemplate.getProductImage())
                .productDescription(productTemplate.getProductDescription())
                .institution(productTemplate.getInstitution())
                .build();
    }

}
