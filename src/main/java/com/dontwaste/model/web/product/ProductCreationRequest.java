package com.dontwaste.model.web.product;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class ProductCreationRequest {
    @NotNull
    private Long branchId;
    @NotNull
    private Long productTemplateId;
    @Min(value = 1)
    @NotNull
    private Double startingPrice;
    @Min(value = 1)
    @NotNull
    private Double price;
    @Min(value = 1)
    @NotNull
    private Integer quantity;



}
