package com.dontwaste.converter;

import com.dontwaste.model.entity.ProductTemplate;
import com.dontwaste.model.entity.Branch;
import com.dontwaste.model.web.product.ProductCreationRequest;
import com.dontwaste.model.web.product.ProductResponse;
import com.dontwaste.model.entity.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product convertToEntity(ProductCreationRequest productCreationRequest,
                                   Branch branch, ProductTemplate productTemplate) {
        return Product.builder()
                .startingPrice(productCreationRequest.getStartingPrice())
                .price(productCreationRequest.getPrice())
                .quantity(productCreationRequest.getQuantity())
                .branch(branch)
                .productTemplate(productTemplate)
                .build();
    }

    public ProductResponse convertToWeb(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .startingPrice(product.getStartingPrice())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .branch(product.getBranch())
                .productTemplate(product.getProductTemplate())
                .build();
    }


}
