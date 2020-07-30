package com.dontwaste.model.web.cart;

import com.dontwaste.model.entity.Branch;
import com.dontwaste.model.entity.ProductTemplate;
import com.dontwaste.model.entity.product.Product;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class ProductsInCartResponce {
    Long id;
    Long userId;
    Integer quantity;

    Product product;
    ProductTemplate productTemplate;
    Branch branch;






}
