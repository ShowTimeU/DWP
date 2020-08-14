package com.dontwaste.repository;

import com.dontwaste.model.entity.Branch;
import com.dontwaste.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    Branch findByUser(User user);
    @Query("SELECT b.branchCity FROM Branch b")
    Set<String> getAllCities();

}
