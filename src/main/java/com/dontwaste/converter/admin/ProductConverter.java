package com.dontwaste.converter.admin;

import com.dontwaste.model.admin.request.ProductCreationRequest;
import com.dontwaste.model.admin.response.ProductCreationResponse;
import com.dontwaste.model.customer.entity.Institution;
import com.dontwaste.model.customer.entity.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product converterToEntity(ProductCreationRequest productCreationRequest, Institution institution) {
        return Product.builder()
                .productName(productCreationRequest.getProductName())
                .description(productCreationRequest.getDescription())
                .image(productCreationRequest.getImage())
                .startingPrice(productCreationRequest.getStartingPrice())
                .price(productCreationRequest.getPrice())
                .institution(institution)
//            .kosher(productCreationRequest.isKosher())
//            .vegan(productCreationRequest.isVegan())
//            .vegeterian(productCreationRequest.isVegeterian())
                .quantity(productCreationRequest.getQuantity())
                .build();
    }

    public ProductCreationResponse convertProductToWeb(Product product){
        return ProductCreationResponse.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .description(product.getDescription())
                .image(product.getImage())
                .startingPrice(product.getStartingPrice())
                .price(product.getPrice())
                .institutionName(product.getInstitution().getInstitutionName())
//                .kosher(productEntity.isKosher())
//                .vegan(productEntity.isVegan())
//                .vegeterian(productEntity.isVegeterian())
                .quantity(product.getQuantity())
                .build();
    }


}
