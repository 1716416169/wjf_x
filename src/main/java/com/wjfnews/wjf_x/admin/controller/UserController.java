package com.wjfnews.wjf_x.admin.controller;

import com.wjfnews.wjf_x.admin.dto.User_UserRole;
import com.wjfnews.wjf_x.admin.entity.User;
import com.wjfnews.wjf_x.admin.entity.UserRole;
import com.wjfnews.wjf_x.admin.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/setUser")
@ResponseBody
@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/insertUser")
    public String insertUser(@RequestBody User_UserRole user_userRole) {
        System.out.println(user_userRole.getUser().toString());
        System.out.println(user_userRole.getUserRole().toString());
        String s = userService.insertUser(user_userRole.getUser(), user_userRole.getUserRole());
        return s;
    }

    @GetMapping("/selectUser")
    public List<User> selectUser(User user) {
        List<User> users = userService.selectUser(user);
        return users;
    }

    @GetMapping("/selectUserByUser")
    public User selectUserByUser(String s) {    //getmapping 不能和@RequestBody同时使用
        System.out.println(s);
        User user1 = userService.selectUserByName(s);
        return user1;
    }

    @PostMapping("/delUserByUser")
    public String delUserByUser(@RequestBody User user) {
        String s = userService.delUser(user);
        return s;
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User_UserRole user_userRole) {
        String s = userService.updateUser(user_userRole.getUser(), user_userRole.getUserRole());
        return s;
    }
}
