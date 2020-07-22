package com.dontwaste.service;

import com.dontwaste.model.customer.entity.User;
import com.dontwaste.model.customer.entity.UserRole;
import com.dontwaste.repository.UserRoleRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class UserRoleServiceImp implements UserRoleService {
    @Autowired
    UserRoleRepositoty userRoleRepositiry;
    @Override
    public List<UserRole> getAllByUser(User user) {
        return userRoleRepositiry.getAllByUser(user);

    }
}
