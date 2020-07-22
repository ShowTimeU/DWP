package com.dontwaste.model.admin.request;

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
    @NotBlank
    private Long institutionId;
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
    @NotBlank
    private String institutionLogo;
    @NotNull
    private Integer quantity;

//    private boolean kosher;
//    private boolean vegeterian;
//    private boolean vegan;



}
