package com.dontwaste.service;

import com.dontwaste.model.customer.entity.User;
import com.dontwaste.model.customer.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    List<UserRole> getAllByUser(User user);


}
