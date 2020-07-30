package com.dontwaste.controller;
import com.dontwaste.model.entity.Branch;
import com.dontwaste.model.web.branch.BranchResponse;
import com.dontwaste.model.web.branch.CreateBranchRequest;
import com.dontwaste.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    BranchService branchService;

    @PostMapping(value = "/addBranch")
    public void addBranch(@RequestBody CreateBranchRequest createBranchRequest,
                          @RequestParam(name = "userId") Long userId,
                          @RequestParam(name = "institutionId") Long institutionId) {
        branchService.addBranch(createBranchRequest, userId, institutionId);
    }

    @GetMapping(value = "/getAllBranches")
    public List<BranchResponse> getAllBranches(){
        return branchService.getAllBranches();
    }

    @DeleteMapping("/deleteBranch")
    public void deleteIBranch(@RequestParam Long id){
        branchService.deleteBranch(id);
    }

}
