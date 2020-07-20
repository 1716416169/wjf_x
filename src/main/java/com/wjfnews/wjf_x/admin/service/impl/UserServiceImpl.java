package com.wjfnews.wjf_x.admin.service.impl;

import com.wjfnews.wjf_x.admin.dao.UserRepository;
import com.wjfnews.wjf_x.admin.dao.UserRoleRepository;
import com.wjfnews.wjf_x.admin.entity.User;
import com.wjfnews.wjf_x.admin.entity.UserRole;
import com.wjfnews.wjf_x.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public String insertUser(User user, UserRole userRole) {
        String password = user.getPassword();
        String encode = new Md4PasswordEncoder().encode(password);
        user.setPassword(encode);
        userRole.setUser(user);
        User save = userRepository.save(user);
        UserRole save1 = userRoleRepository.save(userRole);
        System.out.println(save + "  " + save1);
        return save.getPassword();
    }

    @Override
    public String updateUser(User user, UserRole userRole) {
        User byUser = userRepository.findByUser(user.getUser());
        byUser.setPassword(user.getPassword());
        User save = userRepository.save(byUser);
        return null;
    }


    @Override
    public String delUser(User user) {
        User byUser = userRepository.findByUser(user.getUser());
        userRepository.delete(byUser);
        return null;
    }

    @Override
    public List<User> selectUser(User user) {
        List<User> all = userRepository.findAll();
        return all;
    }

    @Override
    public User selectUserByName(String s) {
        System.out.println("参数：" + s);
        //User user = userRepository.findByUser(s); //查询方法一
        Optional<User> user = userRepository.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Object> user = root.get("user");
                Predicate equal = criteriaBuilder.equal(user, s);
                return equal;
            }
        }); //查询方法二
        //System.out.println(user);
        List<UserRole> roles = user.get().getRoles();
        System.out.println(user.get());
        System.out.println(roles.get(0));
        return user.get();
    }
}
