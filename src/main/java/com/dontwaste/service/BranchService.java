package com.dontwaste.service;

import com.dontwaste.model.web.branch.CreateBranchRequest;
import com.dontwaste.model.web.branch.BranchResponse;

import java.util.List;

public interface BranchService {

    void addBranch(CreateBranchRequest createBranchRequest, Long userId, Long institutionId);
    List<BranchResponse> getAllBranches();
//    BranchResponse getBranch(Long id);
    void deleteBranch(Long id);
}
