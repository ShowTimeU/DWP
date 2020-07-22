package com.dontwaste.model.customer.web.cart;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class ProductsInCartResponce {
    Long id;
    Long userId;
    Long productId;
    String productName;
    String image;
    String description;

    Double price;
    Integer quantity;




}
