package com.wjfnews.wjf_x.admin.configuration;

import com.wjfnews.wjf_x.admin.entity.User;
import com.wjfnews.wjf_x.admin.entity.UserRole;
import com.wjfnews.wjf_x.admin.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("登录的账号：" + s);
        User user = userService.selectUserByName(s);
        if (user.getPassword() == null) {
            System.out.println("登录失败");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        List<UserRole> roles = user.getRoles();
        Iterator<UserRole> iterator = roles.iterator();
        while (iterator.hasNext()) {
            UserRole next = iterator.next();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + next.getRole()));
            System.out.println("ROLE_" + next.getRole());
        }
        return new org.springframework.security.core.userdetails.User(user.getUser(), user.getPassword(), grantedAuthorities);

    }
}
