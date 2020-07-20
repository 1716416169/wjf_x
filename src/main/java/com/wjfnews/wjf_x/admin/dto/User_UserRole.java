package com.wjfnews.wjf_x.admin.dto;

import com.wjfnews.wjf_x.admin.entity.User;
import com.wjfnews.wjf_x.admin.entity.UserRole;

public class User_UserRole {   /*因为spring mvc的@RequestBody每个方法参数里只能写一次，对象参数只能传一个，否则400，所以用一个对象来进行第二次封装*/
    private User user;
    private UserRole userRole;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User_UserRole{" +
                "user=" + user +
                ", userRole=" + userRole +
                '}';
    }
}
