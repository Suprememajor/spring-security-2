package com.supremecorp.springsecurity2.service;

import com.supremecorp.springsecurity2.models.Role;
import com.supremecorp.springsecurity2.models.User;

import java.util.List;

/**
 * Created by suprememajor on the 9/20/21
 */
public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
