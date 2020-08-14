package com.dontwaste.converter;

import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.entity.ProductTemplate;
import com.dontwaste.model.entity.product.productType.DishType;
import com.dontwaste.model.entity.product.productType.KitchenType;
import com.dontwaste.model.web.productTemplate.ProductTemplateCreationRequest;
import com.dontwaste.model.web.productTemplate.ProductTemplateResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductTemplateConverter {

    public ProductTemplate convertToEntity(ProductTemplateCreationRequest productTemplateCreationRequest,
                                           Institution institution,
                                           DishType dishType,
                                           KitchenType kitchenType){
        return ProductTemplate.builder()
                .productName(productTemplateCreationRequest.getProductName())
                .productImage(productTemplateCreationRequest.getProductImage())
                .productDescription(productTemplateCreationRequest.getProductDescription())
                .kosher(productTemplateCreationRequest.isKosher())
                .vegan(productTemplateCreationRequest.isVegan())
                .vegetarian(productTemplateCreationRequest.isVegetarian())
                .institution(institution)
                .dishType(dishType)
                .kitchenType(kitchenType)
                .build();
    }

    public ProductTemplateResponse convertToWeb(ProductTemplate productTemplate){
        return ProductTemplateResponse.builder()
                .id(productTemplate.getId())
                .productName(productTemplate.getProductName())
                .productImage(productTemplate.getProductImage())
                .productDescription(productTemplate.getProductDescription())
                .kosher(productTemplate.isKosher())
                .vegan(productTemplate.isVegan())
                .vegetarian(productTemplate.isVegetarian())
                .institution(productTemplate.getInstitution())
                .build();
    }

}
