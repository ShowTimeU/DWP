package com.dontwaste.model.web.branch;

import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.entity.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BranchResponse {
    private Long id;
    private String branchCity;
    private String branchAddress;
    private String branchPhone;
    private String branchEmail;
    private Institution institution;
    private User user;


}
