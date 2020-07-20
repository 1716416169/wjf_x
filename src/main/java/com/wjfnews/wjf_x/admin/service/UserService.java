package com.wjfnews.wjf_x.admin.service;

import com.wjfnews.wjf_x.admin.entity.User;
import com.wjfnews.wjf_x.admin.entity.UserRole;

import java.util.List;

public interface UserService {
    public String insertUser(User user, UserRole userRole);

    public String updateUser(User user, UserRole userRole);

    public String delUser(User user);

    public List<User> selectUser(User user);

    public User selectUserByName(String s);

}
