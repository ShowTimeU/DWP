package com.dontwaste.model.web.user.response;

import com.dontwaste.model.entity.Branch;
import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.entity.ProductTemplate;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponseForManager extends LoginResponse {

    private LoginResponse loginResponse;
    private Branch branch;
    private Institution institution;
    private List<ProductTemplate> templates;

}
