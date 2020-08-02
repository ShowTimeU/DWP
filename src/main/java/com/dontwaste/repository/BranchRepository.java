package com.dontwaste.repository;

import com.dontwaste.model.entity.Branch;
import com.dontwaste.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    Branch findByUser(User user);

}
