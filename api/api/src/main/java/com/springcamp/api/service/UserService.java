package com.springcamp.api.service;

import com.springcamp.api.entity.User;
import com.springcamp.api.entity.enums.Role;

import java.util.List;

public interface UserService extends Service<User>{

    List<User>getUsersByRole(Role role);

    List<User>getPotentialUsers(List<Integer>ids);
}
