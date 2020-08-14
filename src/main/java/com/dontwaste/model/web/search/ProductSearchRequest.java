package com.dontwaste.model.web.search;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductSearchRequest {

    private Double min;
    private Double max;

    private String productName;
    private boolean vegetarian;
    private boolean kosher;
    private boolean vegan;
    private String dishType;
    private String kitchenType;

    private String institutionName;
    private String city;




}
