package com.dontwaste.repository;

import com.dontwaste.model.entity.User;
import com.dontwaste.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepositoty extends JpaRepository<UserRole, Long> {

    List<UserRole> getAllByUser(User user);
    UserRole getByUser(User user);

}
