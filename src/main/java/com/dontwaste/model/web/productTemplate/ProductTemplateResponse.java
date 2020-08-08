package com.dontwaste.model.web.productTemplate;

import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.entity.product.productType.DishType;
import com.dontwaste.model.entity.product.productType.KitchenType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductTemplateResponse {

    private Long id;
    private String productName;
    private String productDescription;
    private String productImage;
    private boolean kosher;
    private boolean vegetarian;
    private boolean vegan;
    private Institution institution;
    private DishType dishType;
    private KitchenType kitchenType;

}
