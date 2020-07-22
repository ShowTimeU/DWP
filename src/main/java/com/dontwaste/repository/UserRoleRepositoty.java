package com.dontwaste.repository;

import com.dontwaste.model.customer.entity.User;
import com.dontwaste.model.customer.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepositoty extends JpaRepository<UserRole, Long> {

    List<UserRole> getAllByUser(User user);

}
