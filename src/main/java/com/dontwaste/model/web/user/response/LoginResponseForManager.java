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

public class LoginResponseForManager extends LoginResponse {


    @Builder(builderMethodName = "childBuilder")
    public LoginResponseForManager(Long id, String firstName, String lastName,
                                   String email, String phone, String token,
                                   String role, Branch branch, Institution institution,
                                    List<ProductTemplate> templates){
        super(id, firstName, lastName, email, phone, token, role);
        this.branch = branch;
        this.institution = institution;
        this.templates = templates;
    }

    private Branch branch;
    private Institution institution;
    private List<ProductTemplate> templates;

}
