package com.dontwaste.service;

import com.dontwaste.converter.BranchConverter;
import com.dontwaste.model.entity.Branch;
import com.dontwaste.model.entity.Institution;
import com.dontwaste.model.entity.User;
import com.dontwaste.model.web.branch.CreateBranchRequest;
import com.dontwaste.model.web.branch.BranchResponse;
import com.dontwaste.repository.InstitutionRepository;
import com.dontwaste.repository.BranchRepository;
import com.dontwaste.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchServiceImp implements BranchService {
    @Autowired
    BranchRepository branchRepository;
    @Autowired
    BranchConverter branchConverter;
    @Autowired
    UserRepository userRepository;
    @Autowired
    InstitutionRepository institutionRepository;


    @Override
    public void addBranch(CreateBranchRequest createBranchRequest, Long userId, Long institutionId) {
        User user = userRepository.findById(userId).get();
        Institution institution = institutionRepository.findById(institutionId).get();
        if(user == null){
            throw new RuntimeException("user is not exist");
        }
        if(institution == null){
            throw new RuntimeException("institution is not exist");
        }

        Branch branch = branchConverter.convertToEntity(createBranchRequest, user, institution);
        branchRepository.save(branch);
    }

    @Override
    public List<BranchResponse> getAllBranches() {
        List<BranchResponse> branches = new ArrayList<>();
        List<Branch> li =  branchRepository.findAll();
        for(Branch branch : li){
            branches.add(branchConverter.convertToWeb(branch));
        }
//        branchRepository.findAll().stream()
//                .map(branch -> branches.add(branchConverter.convertToWeb(branch)));
        return branches;
    }

//    @Override
//    public BranchResponse getSnif(Long id) {
//        return snifConverter.convertToWeb(snifRepository.findById(id).get());
//    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }
}
