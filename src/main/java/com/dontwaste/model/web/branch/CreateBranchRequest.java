package com.dontwaste.model.web.branch;

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
public class CreateBranchRequest {
    @NotBlank
    @Length(max = 20)
    private String branchCity;
    @NotBlank
    @Length(max = 30)
    private String branchAddress;
    @NotBlank
    @Length(max = 20)
    private String branchPhone;
    @NotBlank
    @Length(max = 20)
    private String branchEmail;
    @NotNull
    private Long institutionId;
    @NotNull
    private Long userId;

}
