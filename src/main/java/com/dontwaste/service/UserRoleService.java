package com.dontwaste.service;

import com.dontwaste.model.entity.User;
import com.dontwaste.model.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    List<UserRole> getAllByUser(User user);


}
