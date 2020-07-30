package com.dontwaste.model.web.product;

import com.dontwaste.model.entity.ProductTemplate;
import com.dontwaste.model.entity.Branch;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class ProductResponse {

    private Long id;
    private Double startingPrice;
    private Double price;
    private Integer quantity;
    private Branch branch;
    private ProductTemplate productTemplate;


}
