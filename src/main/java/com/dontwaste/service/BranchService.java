package com.dontwaste.service;

import com.dontwaste.model.web.branch.CreateBranchRequest;
import com.dontwaste.model.web.branch.BranchResponse;

import java.util.List;
import java.util.Set;

public interface BranchService {

    void addBranch(CreateBranchRequest createBranchRequest, Long userId, Long institutionId);
    List<BranchResponse> getAllBranches();
    BranchResponse getBranch(Long id);
    void deleteBranch(Long id);
    Set<String> getCities();
}
