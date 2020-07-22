package com.dontwaste.model.customer.web.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductToCartRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Long productId;
    @NotBlank
    private String productName;
    @NotBlank
    @Length(min = 6, max = 500)
    private String description;
    @NotBlank
    private String image;
    @Min(value = 1)
    @NotNull
    private Double startingPrice;
    @Min(value = 1)
    @NotNull
    private Double price;
    @NotBlank
    @Length(max = 100)
    private String area;
    @NotBlank
    @Length(max = 50)
    private String institution;
    @NotNull
    private Integer quantity;

}
