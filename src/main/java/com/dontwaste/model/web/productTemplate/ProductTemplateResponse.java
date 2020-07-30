package com.dontwaste.model.web.productTemplate;

import com.dontwaste.model.entity.Institution;
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
    private Institution institution;

}
