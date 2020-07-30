package com.dontwaste.converter;

import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.entity.Branch;
import com.dontwaste.model.entity.User;
import com.dontwaste.model.web.branch.CreateBranchRequest;
import com.dontwaste.model.web.branch.BranchResponse;
import org.springframework.stereotype.Component;

@Component
public class BranchConverter {

    public Branch convertToEntity(CreateBranchRequest createBranchRequest, User user, Institution institution){
        return Branch.builder()
                .branchCity(createBranchRequest.getBranchCity())
                .branchAddress(createBranchRequest.getBranchAddress())
                .branchEmail(createBranchRequest.getBranchEmail())
                .branchPhone(createBranchRequest.getBranchPhone())
                .institution(institution)
                .user(user)
                .build();
    }

    public BranchResponse convertToWeb(Branch branch){
        return BranchResponse.builder()
                .id(branch.getId())
                .branchCity(branch.getBranchCity())
                .branchAddress(branch.getBranchAddress())
                .branchPhone(branch.getBranchPhone())
                .branchEmail(branch.getBranchEmail())
                .institution(branch.getInstitution())
                .user(branch.getUser())
                .build();
    }

}
