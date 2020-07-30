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
    @NotBlank
    @Length(max = 30)
    private String productName;
    @Length(max = 500)
    private String productDescription;
    @Length(max = 2600)
    private String productImage;

}
