package com.dontwaste.model.web.cart;

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
}
