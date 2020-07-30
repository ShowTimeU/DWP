package com.dontwaste.model.web.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductSearchObject {

    private String productName;
    private Double min;
    private Double max;

    private String institutionName;
    private String city;




}
