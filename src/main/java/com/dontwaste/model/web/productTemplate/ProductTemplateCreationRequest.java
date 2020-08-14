package com.dontwaste.model.web.productTemplate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductTemplateCreationRequest {

    @NotNull
    private Long institutionId;
    @NotNull
    private Long kitchenTypeId;
    @NotNull
    private Long dishTypeId;
    @NotBlank
    @Length(max = 30)
    private String productName;
    @Length(max = 500)
    private String productDescription;
    @Length(max = 2600)
    private String productImage;
    @NotBlank
    private boolean kosher;
    @NotBlank
    private boolean vegetarian;
    @NotBlank
    private boolean vegan;

}
