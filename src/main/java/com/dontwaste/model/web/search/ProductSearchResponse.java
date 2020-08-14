package com.dontwaste.model.web.search;

import com.dontwaste.model.entity.Branch;
import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.entity.ProductTemplate;
import com.dontwaste.model.entity.product.Product;
import com.dontwaste.model.entity.product.productType.DishType;
import com.dontwaste.model.entity.product.productType.KitchenType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductSearchResponse {

    private Product product;
    private ProductTemplate productTemplate;
    private Institution institution;
    private Branch branch;
    private DishType dishType;
    private KitchenType kitchenType;
}
